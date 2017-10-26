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
 * 管理员和角色关系
 * </p>
 *
 * @author stylefeng
 * @since 2017-10-25
 */
@TableName("manager_role")
@XmlRootElement(name = "managerRole")
@XmlAccessorType(XmlAccessType.NONE)
@ApiModel(value = "managerRole", description = "管理员和角色关系")
public class ManagerRole extends Model<ManagerRole> {

    private static final long serialVersionUID = 1L;

    /**
     * 关系id
     */
    @TableId(value = "id", type = IdType.AUTO)

    @XmlAttribute
    @ApiModelProperty(value = "关系id", dataType = "Integer")
    private Integer id;
    /**
     * 管理员ID
     */
    @TableField("manager_id")

    @XmlAttribute
    @ApiModelProperty(value = "管理员ID", dataType = "Integer")
    private Integer managerId;
    /**
     * 角色ID
     */
    @TableField("role_id")

    @XmlAttribute
    @ApiModelProperty(value = "角色ID", dataType = "Integer")
    private Integer roleId;


    public ManagerRole() {
    }


    public ManagerRole(
            Integer managerId
            ,
            Integer roleId
    ) {
        this.managerId = managerId;
        this.roleId = roleId;
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

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "ManagerRole{" +
                "id=" + id +
                ", managerId=" + managerId +
                ", roleId=" + roleId +
                "}";
    }
}
