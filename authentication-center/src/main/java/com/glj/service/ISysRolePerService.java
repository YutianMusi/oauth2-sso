package com.glj.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.glj.entity.SysPermissionPo;
import com.glj.entity.SysRolePermissionPo;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author gaoleijie
 * @since 2019-01-11
 */
public interface ISysRolePerService extends IService<SysRolePermissionPo> {
    List<SysPermissionPo> getPermissionPosByRoleId(Integer roleId);
}
