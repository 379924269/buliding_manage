package com.dnp.bulidingmanage.service.impl;

import com.dnp.bulidingmanage.model.Location;
import com.dnp.bulidingmanage.dao.LocationMapper;
import com.dnp.bulidingmanage.service.LocationService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 归属地信息 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2017-10-25
 */
@Service
public class LocationServiceImpl extends ServiceImpl<LocationMapper, Location> implements LocationService {

}
