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
 * 权限信息
 * </p>
 *
 * @author stylefeng
 * @since 2017-10-26
 */
@XmlRootElement(name = "permission")
@XmlAccessorType(XmlAccessType.NONE)
@ApiModel(value = "permission", description = "权限信息")
public class Permission extends Model<Permission> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)

    @XmlAttribute
    @ApiModelProperty(value = "", dataType = "Integer")
    private Integer id;
    /**
     * url描述
     */

    @XmlAttribute
    @ApiModelProperty(value = "url描述", dataType = "String")
    private String name;
    /**
     * 父节点id
     */
    @TableField("parent_id")

    @XmlAttribute
    @ApiModelProperty(value = "父节点id", dataType = "Integer")
    private Integer parentId;
    /**
     * 请求地址
     */
    @TableField("per_url")

    @XmlAttribute
    @ApiModelProperty(value = "请求地址", dataType = "String")
    private String perUrl;
    /**
     * 权限key
     */
    @TableField("per_key")

    @XmlAttribute
    @ApiModelProperty(value = "权限key", dataType = "String")
    private String perKey;

    @XmlAttribute
    @ApiModelProperty(value = "", dataType = "Integer")
    private Integer type;


    public Permission() {
    }


    public Permission(
            String name
            ,
            Integer parentId
            ,
            String perUrl
            ,
            String perKey
            ,
            Integer type
    ) {
        this.name = name;
        this.parentId = parentId;
        this.perUrl = perUrl;
        this.perKey = perKey;
        this.type = type;
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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getPerUrl() {
        return perUrl;
    }

    public void setPerUrl(String perUrl) {
        this.perUrl = perUrl;
    }

    public String getPerKey() {
        return perKey;
    }

    public void setPerKey(String perKey) {
        this.perKey = perKey;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", name=" + name +
                ", parentId=" + parentId +
                ", perUrl=" + perUrl +
                ", perKey=" + perKey +
                ", type=" + type +
                "}";
    }
}
