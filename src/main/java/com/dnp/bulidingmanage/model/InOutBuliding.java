package com.dnp.bulidingmanage.model;

import com.baomidou.mybatisplus.annotations.TableField;
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
 * 记录手机进出大楼的一些信息
 * </p>
 *
 * @author stylefeng
 * @since 2017-10-11
 */
@TableName("in_out_buliding")
@XmlRootElement(name = "inOutBuliding")
@XmlAccessorType(XmlAccessType.NONE)
@ApiModel(value = "inOutBuliding", description = "记录手机进出大楼的一些信息")
public class InOutBuliding extends Model<InOutBuliding> {

    private static final long serialVersionUID = 1L;

    /**
     * 代理id
     */

    @XmlAttribute
    @ApiModelProperty(value = "代理id", dataType = "Integer")
    private Integer id;
    /**
     * 大楼id
     */
    @TableField("buliding_id")

    @XmlAttribute
    @ApiModelProperty(value = "大楼id", dataType = "Integer")
    private Integer bulidingId;
    /**
     * 手机id
     */
    @TableField("device_id")

    @XmlAttribute
    @ApiModelProperty(value = "手机id", dataType = "Integer")
    private Integer deviceId;
    /**
     * 进入大楼时间
     */
    @TableField("in_time")

    @XmlAttribute
    @ApiModelProperty(value = "进入大楼时间", dataType = "Long")
    private Long inTime;
    /**
     * 出大楼时间
     */
    @TableField("out_time")

    @XmlAttribute
    @ApiModelProperty(value = "出大楼时间", dataType = "Long")
    private Long outTime;
    /**
     * 手机验证是否通过,1：合法，0：不合法
     */

    @XmlAttribute
    @ApiModelProperty(value = "手机验证是否通过,1：合法，0：不合法", dataType = "Integer")
    private Integer legal;


    public InOutBuliding() {
    }


    public InOutBuliding(
            Integer bulidingId
            ,
            Integer deviceId
            ,
            Long inTime
            ,
            Long outTime
            ,
            Integer legal
    ) {
        this.bulidingId = bulidingId;
        this.deviceId = deviceId;
        this.inTime = inTime;
        this.outTime = outTime;
        this.legal = legal;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBulidingId() {
        return bulidingId;
    }

    public void setBulidingId(Integer bulidingId) {
        this.bulidingId = bulidingId;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Long getInTime() {
        return inTime;
    }

    public void setInTime(Long inTime) {
        this.inTime = inTime;
    }

    public Long getOutTime() {
        return outTime;
    }

    public void setOutTime(Long outTime) {
        this.outTime = outTime;
    }

    public Integer getLegal() {
        return legal;
    }

    public void setLegal(Integer legal) {
        this.legal = legal;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "InOutBuliding{" +
                "id=" + id +
                ", bulidingId=" + bulidingId +
                ", deviceId=" + deviceId +
                ", inTime=" + inTime +
                ", outTime=" + outTime +
                ", legal=" + legal +
                "}";
    }
}
