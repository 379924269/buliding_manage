package com.dnp.bulidingmanage.common.page;

/**
 * <p>
 * 分页工具类，辅助分页
 *
 * @author Xin.L
 */
public class PageUtil {

    public static String limitSql(int offset, int limit, String order, String sort) {
        return " ORDER BY " + sort + " " + order + " LIMIT " + offset + "," + limit;
    }

    public static String limitSql(int offset, int limit, String order, String sort, String tableAlias) {
        return " ORDER BY " + tableAlias + "." + sort + " " + order + " LIMIT " + offset + "," + limit;
    }
}
