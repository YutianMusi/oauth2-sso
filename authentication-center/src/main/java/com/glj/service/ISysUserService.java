package com.glj.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.glj.entity.SysUserPo;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author gaoleijie
 * @since 2019-01-11
 */
public interface ISysUserService extends IService<SysUserPo> {
    SysUserPo getUserByUserCode(String userCode);
}
