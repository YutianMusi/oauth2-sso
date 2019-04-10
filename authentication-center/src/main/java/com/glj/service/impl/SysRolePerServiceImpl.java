package com.glj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.glj.entity.SysPermissionPo;
import com.glj.entity.SysRolePermissionPo;
import com.glj.mapper.SysRolePermissionMapper;
import com.glj.service.ISysPermissionService;
import com.glj.service.ISysRolePerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author gaoleijie
 * @since 2019-01-11
 */
@Service
public class SysRolePerServiceImpl extends ServiceImpl<SysRolePermissionMapper, SysRolePermissionPo> implements ISysRolePerService {
    @Autowired
    private ISysPermissionService permissionService;

    @Override
    public List<SysPermissionPo> getPermissionPosByRoleId(Integer roleId) {
        QueryWrapper<SysRolePermissionPo> wrapper = new QueryWrapper<>();
        wrapper.eq(SysRolePermissionPo.ROLE_ID, roleId);
        List<SysRolePermissionPo> rolePerPos = this.baseMapper.selectList(wrapper);
        List<SysPermissionPo> sysPermissionPos = new ArrayList<>();
        for (SysRolePermissionPo rolePerPo : rolePerPos) {
            SysPermissionPo sysPermissionPo = permissionService.getById(rolePerPo.getId());
            sysPermissionPos.add(sysPermissionPo);
        }
        return sysPermissionPos;
    }
}
