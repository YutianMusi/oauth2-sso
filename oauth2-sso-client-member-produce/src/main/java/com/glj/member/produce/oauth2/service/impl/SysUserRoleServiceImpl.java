package com.glj.member.produce.oauth2.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.glj.member.produce.oauth2.mapper.SysUserRoleMapper;
import com.glj.member.produce.oauth2.service.ISysRolePerService;
import com.glj.member.produce.oauth2.service.ISysRoleService;
import com.glj.member.produce.oauth2.service.ISysUserRoleService;
import com.glj.model.entity.SysPermissionPo;
import com.glj.model.entity.SysRolePo;
import com.glj.model.entity.SysUserRolePo;

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
