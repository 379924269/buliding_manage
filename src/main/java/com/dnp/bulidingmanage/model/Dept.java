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
 * 部门信息
 * </p>
 *
 * @author stylefeng
 * @since 2017-10-25
 */
@XmlRootElement(name = "dept")
@XmlAccessorType(XmlAccessType.NONE)
@ApiModel(value = "dept", description = "部门信息")
public class Dept extends Model<Dept> {

    private static final long serialVersionUID = 1L;

    /**
     * 部门id
     */
    @TableId(value = "id", type = IdType.AUTO)

    @XmlAttribute
    @ApiModelProperty(value = "部门id", dataType = "Integer")
    private Integer id;
    /**
     * 部门名称
     */

    @XmlAttribute
    @ApiModelProperty(value = "部门名称", dataType = "String")
    private String name;
    /**
     * 部门编号
     */

    @XmlAttribute
    @ApiModelProperty(value = "部门编号", dataType = "String")
    private String number;
    /**
     * 父部门ID
     */
    @TableField("parent_id")

    @XmlAttribute
    @ApiModelProperty(value = "父部门ID", dataType = "Integer")
    private Integer parentId;


    public Dept() {
    }


    public Dept(
            String name
            ,
            String number
            ,
            Integer parentId
    ) {
        this.name = name;
        this.number = number;
        this.parentId = parentId;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", name=" + name +
                ", number=" + number +
                ", parentId=" + parentId +
                "}";
    }
}
