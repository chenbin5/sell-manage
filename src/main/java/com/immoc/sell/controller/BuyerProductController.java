package com.immoc.sell.controller;

import com.immoc.sell.VO.ProductInfoVO;
import com.immoc.sell.VO.ProductVO;
import com.immoc.sell.VO.ResultVO;
import com.immoc.sell.dataobject.ProductCategroy;
import com.immoc.sell.dataobject.ProductInfo;
import com.immoc.sell.service.ProductCategroyService;
import com.immoc.sell.service.ProductInfoService;
import com.immoc.sell.util.ResultVoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.Sides;
import java.awt.print.PrinterJob;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/**
 * 买家商品
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    private final Logger logger = LoggerFactory.getLogger(BuyerProductController.class);

    @Autowired
    private ProductInfoService productInfoService;
    @Autowired
    private ProductCategroyService productCategroyService;

    @GetMapping("/list")
    public ResultVO queryProductList() {

        //1.查询所有上架的商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();
        //2.查询类目（一次性查询类目）
        //List<Integer> categroyTypeList = new ArrayList<>();
        //传统的方法
        /*for (ProductInfo productInfo : productInfoList) {
            categroyTypeList.add(productInfo.getCategroyType());
        }*/
        //使用jdk1.8新特性
        List<Integer> categroyTypeList = productInfoList.stream()
                .map(e->e.getCategroyType())
                .collect(Collectors.toList());
        List<ProductCategroy> productCategroyList = productCategroyService.findByCategroyTypeIn(categroyTypeList);
        //3.数据的拼装
        List<ProductVO> productVOList  = new ArrayList<>();
        for (ProductCategroy productCategroy : productCategroyList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategroyName(productCategroy.getCategroyName());
            productVO.setCategroyType(productCategroy.getCategroyType());
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategroyType().equals(productCategroy.getCategroyType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVos(productInfoVOList);
            productVOList.add(productVO);
        }
        //logger.info(JSONObject.toJSONString(productVOList));
        return ResultVoUtil.success(productVOList);
    }

    /**
     * 上传图片
     * @param files
     */
    @RequestMapping(value = "/uploadImage")
    @ResponseBody
    public void uploadImage(@RequestParam(value="file",required = false) MultipartFile[] files) {
        System.out.println("~~~~~本次上传的图片张数为：~~~~" + files.length + "张~~~~~~~~");
        String filePath = "E:/20191230image";
        if (files.length != 0) {
            for (MultipartFile multipartFile : files) {
                System.out.println("文件"+multipartFile.getOriginalFilename());
                String fileName = multipartFile.getOriginalFilename();
                try {
                    uploadFile(multipartFile.getBytes(),filePath,fileName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 将图片写入磁盘
     * @param file
     * @param filePath
     * @param fileName
     * @throws Exception
     */
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        File file1 = new File(filePath +"/"+ fileName);
        FileOutputStream out = new FileOutputStream(file1);
        out.write(file);
        System.out.println("~~~~~ 开始打印照片 ~~~~~");
        PDFPrint(file1,"HP LaserJet MFP M427fdw");
        System.out.println("~~~~~ 打印照结束 ~~~~~~");
        //删除图片
        String result = delFile(file1);
        System.out.println("删除返回结果为：" + result);
        out.flush();
        out.close();
    }

    /**
     * 删除照片
     * @param file
     * @return
     */
    public static String delFile(File file) {
        String resultInfo = "";
        if (file.exists()) {
            if (file.delete()) {
                resultInfo =  "1";
            } else {
                resultInfo =  "0";
            }
        } else {
            resultInfo = "文件不存在！";
        }
        return resultInfo;
    }
    /**
     * 打印图片
     * @param file
     * @param printerName
     * @throws PrintException
     */
    public static void PDFPrint(File file,String printerName) throws PrintException {
        if (file == null) {
            System.err.println("缺少打印文件");
        }
        InputStream fis = null;
        try {
            // 设置打印格式，如果未确定类型，可选择autosense
            DocFlavor flavor = DocFlavor.INPUT_STREAM.JPEG;
            // 设置打印参数
            PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
            aset.add(new Copies(1)); //份数
            aset.add(Sides.DUPLEX);//单双面
            // 定位打印服务
            PrintService printService = null;
            if (printerName != null) {
                //获得本台电脑连接的所有打印机
                PrintService[] printServices = PrinterJob.lookupPrintServices();
                if(printServices == null || printServices.length == 0) {
                    System.out.print("打印失败，未找到可用打印机，请检查。");
                    return ;
                }
                //匹配指定打印机
                for (int i = 0;i < printServices.length; i++) {
                    System.out.println(printServices[i].getName());
                    if (printServices[i].getName().contains(printerName)) {
                        printService = printServices[i];
                        break;
                    }
                }
                if(printService==null){
                    System.out.print("打印失败，未找到名称为" + printerName + "的打印机，请检查。");
                    return ;
                }
            }
            fis = new FileInputStream(file); // 构造待打印的文件流
            Doc doc = new SimpleDoc(fis, flavor, null);
            DocPrintJob job = printService.createPrintJob(); // 创建打印作业
            job.print(doc, aset);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } finally {
            // 关闭打印的文件流
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

