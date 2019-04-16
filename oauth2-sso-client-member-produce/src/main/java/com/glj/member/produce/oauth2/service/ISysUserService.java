package com.glj.member.produce.oauth2.service;


import com.glj.model.entity.SysUserPo;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author gaoleijie
 * @since 2019-01-11
 */
public interface ISysUserService {
    SysUserPo getUserByUserCode(String userCode);
}
