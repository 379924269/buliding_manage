package com.dnp.bulidingmanage.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
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
 * 角色
 * </p>
 *
 * @author stylefeng
 * @since 2017-10-25
 */
@XmlRootElement(name = "role")
@XmlAccessorType(XmlAccessType.NONE)
@ApiModel(value = "role", description = "角色")
public class Role extends Model<Role> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色id
     */
    @TableId(value = "id", type = IdType.AUTO)

    @XmlAttribute
    @ApiModelProperty(value = "角色id", dataType = "Integer")
    private Integer id;
    /**
     * 角色名称
     */

    @XmlAttribute
    @ApiModelProperty(value = "角色名称", dataType = "String")
    private String name;
    /**
     * 允许删除，0：不能删除，1：可以删除
     */
    @TableField("allow_delete")

    @XmlAttribute
    @ApiModelProperty(value = "允许删除，0：不能删除，1：可以删除", dataType = "Integer")
    private Integer allowDelete;


    public Role() {
    }


    public Role(
            String name
            ,
            Integer allowDelete
    ) {
        this.name = name;
        this.allowDelete = allowDelete;
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

    public Integer getAllowDelete() {
        return allowDelete;
    }

    public void setAllowDelete(Integer allowDelete) {
        this.allowDelete = allowDelete;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name=" + name +
                ", allowDelete=" + allowDelete +
                "}";
    }
}
