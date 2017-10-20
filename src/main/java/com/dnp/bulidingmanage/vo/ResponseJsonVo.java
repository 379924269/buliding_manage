package com.dnp.bulidingmanage.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "responseJsonVo")
@XmlAccessorType(XmlAccessType.NONE)
@ApiModel(value = "responseJsonVo", description = "返回信息")
public class ResponseJsonVo implements Serializable {
    /**
     * @Fields serialVersionUID :
     */
    private static final long serialVersionUID = 1L;
    @XmlAttribute
    @ApiModelProperty(value = "http状态", dataType = "Integer", required = true)
    private Integer code;

    @XmlElement
    @ApiModelProperty(value = "result结果", dataType = "Boolean", required = false)
    private boolean result;

    @XmlElement
    @ApiModelProperty(value = "返回信息", dataType = "String", required = false)
    private String message;

    /**
     * 简单的响应
     *
     * @param code    status状态码
     * @param result  结果
     * @param message 响应的消息
     */
    public ResponseJsonVo(Integer code, boolean result, String message) {
        this.code = code;
        this.result = result;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
