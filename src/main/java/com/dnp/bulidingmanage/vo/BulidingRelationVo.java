package com.dnp.bulidingmanage.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 大楼关联实体类
 *
 * @Author 华仔
 * @Author 2017/10/20 10:20
 */
@XmlRootElement(name = "bulidingRelationVo")
@XmlAccessorType(XmlAccessType.NONE)
@ApiModel(value = "bulidingRelationVo", description = "大楼关联信息")
public class BulidingRelationVo {
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
    @XmlAttribute
    @ApiModelProperty(value = "开关功能id", dataType = "Integer")
    private Integer policyId;

    /**
     * 策略名称
     */

    @XmlAttribute
    @ApiModelProperty(value = "策略名称", dataType = "String")
    private String policyName;
    /**
     * 开关功能
     */

    @XmlAttribute
    @ApiModelProperty(value = "开关功能", dataType = "String")
    private String policycontent;

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

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public String getPolicycontent() {
        return policycontent;
    }

    public void setPolicycontent(String policycontent) {
        this.policycontent = policycontent;
    }
}
