package com.dnp.bulidingmanage.common;

import org.slf4j.LoggerFactory;

/**
 * 打印日志（可配置开关）
 *
 * @Author 华仔
 * @Author 2017/10/20 9:54
 */
public class LogUtil {
    /**
     * 日志信息
     *
     * @param className 类，可以用this代替
     * @param logMsg    返回消息
     */
    public static void info(Object className, String logMsg) {
        LoggerFactory.getLogger(className.getClass()).info(logMsg);
    }

    /**
     * 日志信息
     *
     * @param className 类，可以用this代替
     * @param logMsg    返回消息
     */
    public static void debug(Object className, String logMsg) {
        LoggerFactory.getLogger(className.getClass()).debug(logMsg);
    }

    /**
     * 日志信息
     *
     * @param className 类，可以用this代替
     * @param logMsg    返回消息
     */
    public static void error(Object className, String logMsg) {
        LoggerFactory.getLogger(className.getClass()).error(logMsg);
    }

}
