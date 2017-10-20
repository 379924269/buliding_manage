package com.dnp.bulidingmanage.common.exception;

import com.dnp.bulidingmanage.common.LogUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理
 *
 * @Author 华仔
 * @Author 2017/10/20 15:31
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 全局异常捕捉处理
     *
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map errorHandler(Exception ex) {
        LogUtil.info(this, "异常：" + ex.getMessage());

        Map map = new HashMap();
        map.put("code", 100);
        map.put("result", false);
        map.put("msg", ex.getMessage());
        return map;
    }
}
