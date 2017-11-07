package com.dnp.bulidingmanage.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

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
 * 系统日志
 * </p>
 *
 * @author stylefeng
 * @since 2017-11-06
 */
@TableName("system_log")
@XmlRootElement(name = "systemLog")
@XmlAccessorType(XmlAccessType.NONE)
@ApiModel(value = "systemLog", description = "系统日志")
public class SystemLog extends Model<SystemLog> {

    private static final long serialVersionUID = 1L;

    /**
     * 代理id
     */
    @TableId(value = "id", type = IdType.AUTO)

    @XmlAttribute
    @ApiModelProperty(value = "代理id", dataType = "Integer")
    private Integer id;
    /**
     * 管理员id
     */
    @TableField("manager_id")

    @XmlAttribute
    @ApiModelProperty(value = "管理员id", dataType = "Integer")
    private Integer managerId;
    /**
     * 管理员名称
     */
    @TableField("manager_name")

    @XmlAttribute
    @ApiModelProperty(value = "管理员名称", dataType = "String")
    private String managerName;
    /**
     * 管理员账号
     */
    @TableField("manager_account")

    @XmlAttribute
    @ApiModelProperty(value = "管理员账号", dataType = "String")
    private String managerAccount;
    /**
     * 日志描述
     */

    @XmlAttribute
    @ApiModelProperty(value = "日志描述", dataType = "String")
    private String description;
    /**
     * 创建时间
     */
    @TableField("created_date")

    @XmlAttribute
    @ApiModelProperty(value = "创建时间", dataType = "Long")
    private Long createdDate;
    /**
     * 客户端IP
     */
    @TableField("client_ip")

    @XmlAttribute
    @ApiModelProperty(value = "客户端IP", dataType = "String")
    private String clientIp;

    public SystemLog() {
    }


    public SystemLog(
            Integer managerId
            ,
            String managerName
            ,
            String managerAccount
            ,
            String description
            ,
            Long createdDate
            ,
            String clientIp
    ) {
        this.managerId = managerId;
        this.managerName = managerName;
        this.managerAccount = managerAccount;
        this.description = description;
        this.createdDate = createdDate;
        this.clientIp = clientIp;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerAccount() {
        return managerAccount;
    }

    public void setManagerAccount(String managerAccount) {
        this.managerAccount = managerAccount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SystemLog{" +
                "id=" + id +
                ", managerId=" + managerId +
                ", managerName=" + managerName +
                ", managerAccount=" + managerAccount +
                ", description=" + description +
                ", createdDate=" + createdDate +
                ", clientIp=" + clientIp +
                "}";
    }
}
