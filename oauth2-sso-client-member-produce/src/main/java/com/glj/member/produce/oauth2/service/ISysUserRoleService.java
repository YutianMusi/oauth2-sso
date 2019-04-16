package com.glj.member.produce.oauth2.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.glj.model.entity.SysRolePo;
import com.glj.model.entity.SysUserRolePo;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author gaoleijie
 * @since 2019-01-11
 */
public interface ISysUserRoleService extends IService<SysUserRolePo> {
    List<SysRolePo> getRolesByUserId(Integer userId);
}
