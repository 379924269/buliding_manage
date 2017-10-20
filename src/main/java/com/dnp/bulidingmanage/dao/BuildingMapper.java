package com.dnp.bulidingmanage.dao;

import com.dnp.bulidingmanage.model.Building;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.dnp.bulidingmanage.vo.BulidingRelationVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2017-10-11
 */
public interface BuildingMapper extends BaseMapper<Building> {
    /**
     * 获取大楼所有关联信息
     *
     * @param search 模糊查询字段（名称）
     * @return list List<BulidingRelationVo>
     */
    List<BulidingRelationVo> selectAllRelation(@Param("search") String search);

    int countAllRelation(@Param("search") String search);

}