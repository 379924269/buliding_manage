package com.dnp.bulidingmanage.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.dnp.bulidingmanage.common.ResponseUtil;
import com.dnp.bulidingmanage.common.page.PageVo;
import com.dnp.bulidingmanage.model.Building;
import com.dnp.bulidingmanage.dao.BuildingMapper;
import com.dnp.bulidingmanage.service.BuildingService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dnp.bulidingmanage.vo.BulidingRelationVo;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2017-10-11
 */
@Service
public class BuildingServiceImpl extends ServiceImpl<BuildingMapper, Building> implements BuildingService {

    @Autowired
    BuildingMapper buildingMapper;

    @Override
    public String findAllRelation(PageVo pageVo, String search) {
        PageHelper.offsetPage(pageVo.getOffset(), pageVo.getLimit());
        List<BulidingRelationVo> list = buildingMapper.selectAllRelation(search);
        return ResponseUtil.responsePage(buildingMapper.countAllRelation(search), list);
    }

    @Override
    public String findAll(PageVo pageVo, String search) {
        //下面代码都是调用的mybaits-helper的
        EntityWrapper entityWrapper = new EntityWrapper();
        if (StringUtils.isNotEmpty(search)) {
            entityWrapper.like("name", search);
        }
        Page page = new Page(pageVo.getOffset()/pageVo.getLimit(), pageVo.getLimit());
        List<Building> list = buildingMapper.selectPage(page, entityWrapper);
        int total = buildingMapper.selectCount(entityWrapper);
        return ResponseUtil.responsePage(total, list);
    }
}
