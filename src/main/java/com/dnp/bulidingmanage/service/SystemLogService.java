package com.dnp.bulidingmanage.service;

import com.dnp.bulidingmanage.common.page.PageVo;
import com.dnp.bulidingmanage.model.SystemLog;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 系统日志 服务类
 * </p>
 *
 * @author stylefeng
 * @since 2017-11-06
 */
public interface SystemLogService extends IService<SystemLog> {

    /**
     * 查看所有日志
     * @param pageVo 分页参数
     * @param search 模糊查询字段（description）
     * @return string 封装好了的分页结果
     */
    String findAllLog(PageVo pageVo, String search);
	
}
