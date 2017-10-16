package com.dnp.bulidingmanage.model;

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
 * 进出大楼要开关的一些功能策略
 * </p>
 *
 * @author stylefeng
 * @since 2017-10-11
 */
@XmlRootElement(name = "policy")
@XmlAccessorType(XmlAccessType.NONE)
@ApiModel(value = "policy", description = "进出大楼要开关的一些功能策略")
public class Policy extends Model<Policy> {

    private static final long serialVersionUID = 1L;

    /**
     * 代理id
     */

    @XmlAttribute
    @ApiModelProperty(value = "代理id", dataType = "Integer")
    private Integer id;
    /**
     * 策略名称
     */

    @XmlAttribute
    @ApiModelProperty(value = "策略名称", dataType = "String")
    private String name;
    /**
     * 开关功能
     */

    @XmlAttribute
    @ApiModelProperty(value = "开关功能", dataType = "String")
    private String content;


    public Policy() {
    }


    public Policy(
            String name
            ,
            String content
    ) {
        this.name = name;
        this.content = content;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "id=" + id +
                ", name=" + name +
                ", content=" + content +
                "}";
    }
}
