package com.dnp.bulidingmanage.common.swagger.ResponsePageResult;

import com.dnp.bulidingmanage.model.Building;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "builidingPageResult")
@XmlAccessorType(XmlAccessType.NONE)
@ApiModel(value = "builidingPageResult", description = "大楼信息")
public class BuilidingPageResult implements Serializable {
    /**
     * @Fields serialVersionUID :
     */
    private static final long serialVersionUID = 1L;
    @XmlElement(name = "total")
    @ApiModelProperty(value = "列总条数", dataType = "Integer", required = false)
    private int total;
    @XmlElement(name = "rows")
    @ApiModelProperty(value = "分页后每一列的详情", dataType = "list", required = false)
    private List<Building> rows = new ArrayList<>();

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Building> getRows() {
        return rows;
    }

    public void setRows(List<Building> rows) {
        this.rows = rows;
    }


}

