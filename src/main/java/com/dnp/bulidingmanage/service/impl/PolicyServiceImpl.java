package com.dnp.bulidingmanage.service.impl;

import com.dnp.bulidingmanage.model.Policy;
import com.dnp.bulidingmanage.dao.PolicyMapper;
import com.dnp.bulidingmanage.service.PolicyService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 进出大楼要开关的一些功能策略 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2017-10-11
 */
@Service
public class PolicyServiceImpl extends ServiceImpl<PolicyMapper, Policy> implements PolicyService {

}
