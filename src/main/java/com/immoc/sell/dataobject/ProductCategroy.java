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

    public Integer getCategroyId() {
        return categroyId;
    }

    public String getCategroyName() {
        return categroyName;
    }

    public Integer getCategroyType() {
        return categroyType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setCategroyId(Integer categroyId) {
        this.categroyId = categroyId;
    }

    public void setCategroyName(String categroyName) {
        this.categroyName = categroyName;
    }

    public void setCategroyType(Integer categroyType) {
        this.categroyType = categroyType;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
