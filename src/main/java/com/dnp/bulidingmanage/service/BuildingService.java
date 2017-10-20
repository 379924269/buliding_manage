package com.dnp.bulidingmanage.service;

import com.dnp.bulidingmanage.common.page.PageVo;
import com.dnp.bulidingmanage.model.Building;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author stylefeng
 * @since 2017-10-11
 */
public interface BuildingService extends IService<Building> {
    /**
     * 获取所有大楼关联的相关信息
     *
     * @param pageVo 分页实体类
     * @param search 模糊查询值（根据名称模糊查询）
     * @return string 封装好了分页结构{total：xx，rows：[]}
     */
    String findAllRelation(PageVo pageVo, String search);

    /**
     * 获取所有大楼信息
     *
     * @param pageVo 分页实体类
     * @param search 模糊查询值（根据名称模糊查询）
     * @return string 封装好了分页结构{total：xx，rows：[]}
     */
    String findAll(PageVo pageVo, String search);
}
