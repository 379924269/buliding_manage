package com.dnp.bulidingmanage.model;

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
 * 归属地信息
 * </p>
 *
 * @author stylefeng
 * @since 2017-10-25
 */
@XmlRootElement(name = "location")
@XmlAccessorType(XmlAccessType.NONE)
@ApiModel(value = "location", description = "归属地信息")
public class Location extends Model<Location> {

    private static final long serialVersionUID = 1L;

    /**
     * 代理id
     */
    @TableId(value = "id", type = IdType.AUTO)

    @XmlAttribute
    @ApiModelProperty(value = "代理id", dataType = "Integer")
    private Integer id;
    /**
     * 归属地名称
     */

    @XmlAttribute
    @ApiModelProperty(value = "归属地名称", dataType = "String")
    private String name;
    /**
     * 归属地编号
     */

    @XmlAttribute
    @ApiModelProperty(value = "归属地编号", dataType = "String")
    private String number;


    public Location() {
    }


    public Location(
            String name
            ,
            String number
    ) {
        this.name = name;
        this.number = number;
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

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name=" + name +
                ", number=" + number +
                "}";
    }
}
