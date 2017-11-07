package com.dnp.bulidingmanage.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.dnp.bulidingmanage.common.ResponseUtil;
import com.dnp.bulidingmanage.common.page.PageVo;
import com.dnp.bulidingmanage.model.SystemLog;
import com.dnp.bulidingmanage.dao.SystemLogMapper;
import com.dnp.bulidingmanage.service.SystemLogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;

/**
 * <p>
 * 系统日志 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2017-11-06
 */
@Service
public class SystemLogServiceImpl extends ServiceImpl<SystemLogMapper, SystemLog> implements SystemLogService {

    @Autowired
    private SystemLogMapper systemLogMapper;

    @Override
    public String findAllLog(PageVo pageVo, String search) {
        PageHelper.offsetPage(pageVo.getOffset(), pageVo.getLimit());
        EntityWrapper<SystemLog> entityWrapper = new EntityWrapper<>();
        if (StringUtils.isNotEmpty(search)) {
            entityWrapper.like("description", search);
        }
        List<SystemLog> list = systemLogMapper.selectList(entityWrapper);
        int total = systemLogMapper.selectCount(entityWrapper);
        return ResponseUtil.responsePage(total, list);
    }
}
