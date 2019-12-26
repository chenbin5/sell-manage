package com.immoc.sell.dataobject;



import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 类目表
 */
@Entity
//@DynamicUpdate 时间自动更新
@Data
public class ProductCategroy {

    /**类目id*/
    @Id
    @GeneratedValue
    private Integer categroyId;
    /**类目名称*/
    private String categroyName;
    /**类目类型*/
    private Integer categroyType;
    /**创建时间*/
    private Date createTime;
    /**更新时间*/
    private Date updateTime;
}
