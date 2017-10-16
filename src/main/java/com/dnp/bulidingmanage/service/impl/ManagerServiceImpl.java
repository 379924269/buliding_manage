package com.dnp.bulidingmanage.service.impl;

import com.dnp.bulidingmanage.model.Manager;
import com.dnp.bulidingmanage.dao.ManagerMapper;
import com.dnp.bulidingmanage.service.ManagerService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员表 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2017-10-11
 */
@Service
public class ManagerServiceImpl extends ServiceImpl<ManagerMapper, Manager> implements ManagerService {

}
