package com.glj.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.glj.entity.SysRolePo;
import com.glj.entity.SysUserRolePo;

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
    public List<SysRolePo> getRolesByUserId(Integer userId);
}
