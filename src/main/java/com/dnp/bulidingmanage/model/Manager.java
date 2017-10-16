package com.dnp.bulidingmanage.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>
 * 管理员表
 * </p>
 *
 * @author stylefeng
 * @since 2017-10-11
 */
@XmlRootElement(name = "manager")
@XmlAccessorType(XmlAccessType.NONE)
@ApiModel(value = "manager", description = "管理员表")
public class Manager extends Model<Manager> {

    private static final long serialVersionUID = 1L;

    /**
     * 代理id
     */

    @XmlAttribute
    @ApiModelProperty(value = "代理id", dataType = "Integer")
    private Integer id;
    /**
     * 管理员名
     */

    @XmlAttribute
    @ApiModelProperty(value = "管理员名", dataType = "String")
    private String name;
    /**
     * 管理员账号
     */

    @XmlAttribute
    @ApiModelProperty(value = "管理员账号", dataType = "String")
    private String account;
    /**
     * 管理员密码
     */

    @XmlAttribute
    @ApiModelProperty(value = "管理员密码", dataType = "String")
    private String password;
    /**
     * 创建时间
     */
    @TableField("created_date")

    @XmlAttribute
    @ApiModelProperty(value = "创建时间", dataType = "Long")
    private Long createdDate;
    /**
     * 删除，1：允许，0：不允许
     */
    @TableField("allow_deleted")

    @XmlAttribute
    @ApiModelProperty(value = "删除，1：允许，0：不允许", dataType = "Integer")
    private Integer allowDeleted;


    public Manager() {
    }


    public Manager(
            String name
            ,
            String account
            ,
            String password
            ,
            Long createdDate
            ,
            Integer allowDeleted
    ) {
        this.name = name;
        this.account = account;
        this.password = password;
        this.createdDate = createdDate;
        this.allowDeleted = allowDeleted;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getAllowDeleted() {
        return allowDeleted;
    }

    public void setAllowDeleted(Integer allowDeleted) {
        this.allowDeleted = allowDeleted;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", name=" + name +
                ", account=" + account +
                ", password=" + password +
                ", createdDate=" + createdDate +
                ", allowDeleted=" + allowDeleted +
                "}";
    }
}
