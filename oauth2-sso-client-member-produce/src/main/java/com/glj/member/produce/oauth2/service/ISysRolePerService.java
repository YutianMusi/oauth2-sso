package com.glj.member.produce.oauth2.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.glj.model.entity.SysPermissionPo;
import com.glj.model.entity.SysRolePermissionPo;

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
