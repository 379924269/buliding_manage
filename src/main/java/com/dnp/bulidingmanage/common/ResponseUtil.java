package com.dnp.bulidingmanage.common;

import org.json.JSONObject;

import java.util.List;

/**
 * @Author 华仔
 * @Author 2017/10/20 12:09
 */
public class ResponseUtil {

    /**
     * 够着一个分页返回,如{total：xx,rows:[]}
     *
     * @param total 总条数
     * @param list  分页集合
     * @return string jsonstring
     */
    public static String responsePage(int total, List list) {
        return new JSONObject().put("total", total).put("rows", list).toString();
    }
}
