package com.dnp.bulidingmanage.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 打印日志（可配置开关）
 * @Author 华仔
 * @Author 2017/10/20 9:54
 */
public class LogUtil {
    public static void info(Object className, String logMsg) {
        LoggerFactory.getLogger(className.getClass()).info(logMsg);
    }

    public static void debug(Object className, String logMsg) {
        LoggerFactory.getLogger(className.getClass()).debug(logMsg);
    }

    public static void error(Object className, String logMsg) {
        LoggerFactory.getLogger(className.getClass()).error(logMsg);
    }

}
