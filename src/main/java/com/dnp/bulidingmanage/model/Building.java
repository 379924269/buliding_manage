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
 * <p>
 * </p>
 *
 * @author stylefeng
 * @since 2017-10-11
 */
@XmlRootElement(name = "building")
@XmlAccessorType(XmlAccessType.NONE)
@ApiModel(value = "building", description = "")
public class Building extends Model<Building> {

    private static final long serialVersionUID = 1L;

    /**
     * 代理id
     */

    @XmlAttribute
    @ApiModelProperty(value = "代理id", dataType = "Integer")
    private Integer id;
    /**
     * 大楼名称
     */

    @XmlAttribute
    @ApiModelProperty(value = "大楼名称", dataType = "String")
    private String name;
    /**
     * 大楼编号
     */

    @XmlAttribute
    @ApiModelProperty(value = "大楼编号", dataType = "String")
    private String number;
    /**
     * 开关功能id
     */
    @TableField("policy_id")

    @XmlAttribute
    @ApiModelProperty(value = "开关功能id", dataType = "Integer")
    private Integer policyId;


    public Building() {
    }


    public Building(
            String name
            ,
            String number
            ,
            Integer policyId
    ) {
        this.name = name;
        this.number = number;
        this.policyId = policyId;
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

    public Integer getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Integer policyId) {
        this.policyId = policyId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", name=" + name +
                ", number=" + number +
                ", policyId=" + policyId +
                "}";
    }
}
