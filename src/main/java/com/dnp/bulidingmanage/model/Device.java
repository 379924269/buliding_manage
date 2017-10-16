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
 * 手机的一些信息
 * </p>
 *
 * @author stylefeng
 * @since 2017-10-11
 */
@XmlRootElement(name = "device")
@XmlAccessorType(XmlAccessType.NONE)
@ApiModel(value = "device", description = "手机的一些信息")
public class Device extends Model<Device> {

    private static final long serialVersionUID = 1L;

    /**
     * 代理id
     */
    @TableId(value = "id", type = IdType.AUTO)

    @XmlAttribute
    @ApiModelProperty(value = "代理id", dataType = "Integer")
    private Integer id;
    /**
     * imei
     */

    @XmlAttribute
    @ApiModelProperty(value = "imei", dataType = "String")
    private String imei;
    /**
     * imsi
     */

    @XmlAttribute
    @ApiModelProperty(value = "imsi", dataType = "String")
    private String imsi;
    /**
     * imfi
     */

    @XmlAttribute
    @ApiModelProperty(value = "imfi", dataType = "String")
    private String imfi;
    /**
     * 号码
     */

    @XmlAttribute
    @ApiModelProperty(value = "号码", dataType = "String")
    private String phone;


    public Device() {
    }


    public Device(
            String imei
            ,
            String imsi
            ,
            String imfi
            ,
            String phone
    ) {
        this.imei = imei;
        this.imsi = imsi;
        this.imfi = imfi;
        this.phone = phone;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getImfi() {
        return imfi;
    }

    public void setImfi(String imfi) {
        this.imfi = imfi;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", imei=" + imei +
                ", imsi=" + imsi +
                ", imfi=" + imfi +
                ", phone=" + phone +
                "}";
    }
}
