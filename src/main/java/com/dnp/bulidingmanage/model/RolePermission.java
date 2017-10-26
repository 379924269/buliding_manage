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
 * 角色权限关系表
 * </p>
 *
 * @author stylefeng
 * @since 2017-10-25
 */
@TableName("role_permission")
@XmlRootElement(name = "rolePermission")
@XmlAccessorType(XmlAccessType.NONE)
@ApiModel(value = "rolePermission", description = "角色权限关系表")
public class RolePermission extends Model<RolePermission> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)

    @XmlAttribute
    @ApiModelProperty(value = "", dataType = "Integer")
    private Integer id;
    /**
     * 角色ID
     */
    @TableField("role_id")

    @XmlAttribute
    @ApiModelProperty(value = "角色ID", dataType = "Integer")
    private Integer roleId;
    /**
     * 权限ID
     */
    @TableField("permission_id")

    @XmlAttribute
    @ApiModelProperty(value = "权限ID", dataType = "Integer")
    private Integer permissionId;


    public RolePermission() {
    }


    public RolePermission(
            Integer roleId
            ,
            Integer permissionId
    ) {
        this.roleId = roleId;
        this.permissionId = permissionId;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "RolePermission{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", permissionId=" + permissionId +
                "}";
    }
}
