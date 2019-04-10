package com.glj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.glj.entity.SysPermissionPo;
import com.glj.entity.SysRolePo;
import com.glj.entity.SysUserRolePo;
import com.glj.mapper.SysUserRoleMapper;
import com.glj.service.ISysRolePerService;
import com.glj.service.ISysRoleService;
import com.glj.service.ISysUserRoleService;
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
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRolePo> implements ISysUserRoleService {
    @Autowired
    private ISysRoleService roleService;
    @Autowired
    private ISysRolePerService rolePerService;

    @Override
    public List<SysRolePo> getRolesByUserId(Integer userId) {
        QueryWrapper<SysUserRolePo> wrapper = new QueryWrapper<>();
        wrapper.eq(SysUserRolePo.USER_ID, userId);
        List<SysUserRolePo> userRolePos = this.baseMapper.selectList(wrapper);
        List<SysRolePo> sysRolePos = new ArrayList<>();
        for (SysUserRolePo role : userRolePos) {
            SysRolePo rolePo = roleService.getById(role.getRoleId());
            List<SysPermissionPo> permissionPos = rolePerService.getPermissionPosByRoleId(rolePo.getId());
            rolePo.setPermissionPoList(permissionPos);
            sysRolePos.add(rolePo);
        }
        return sysRolePos;
    }
}
