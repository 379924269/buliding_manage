package com.dnp.bulidingmanage.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dnp.bulidingmanage.dao.ManagerMapper;
import com.dnp.bulidingmanage.model.Manager;
import com.dnp.bulidingmanage.service.ManagerService;
import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    @Autowired
    private ManagerMapper managerMapper;

    @Override
    public Manager selectByAccout(String account) {
        EntityWrapper entityWrapper = new EntityWrapper<Manager>();
        entityWrapper.eq("account", account);
        List<Manager> managerInfo = managerMapper.selectList(entityWrapper);
        return managerInfo.size() == 0 ? null : managerInfo.get(0);
    }

    @Override
    public String selectRoleIds(String account) {
        JSONArray roleIdArray = new JSONArray();
        List<Map<String, Object>> managerinfo = managerMapper.selectRoleIds(account);
        for (int i = 0; i < managerinfo.size(); i++) {
            roleIdArray.put(managerinfo.get(0).get("roleId").toString());
        }

        return StringUtils.substring(roleIdArray.toString(), 2,roleIdArray.toString().length() -2);
    }
}
