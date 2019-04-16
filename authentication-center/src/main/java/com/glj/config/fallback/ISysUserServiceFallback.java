package com.glj.config.fallback;

import com.glj.model.entity.SysUserPo;
import com.glj.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @ClassName ISysUserServiceFallback
 * @Description TODO
 * @Author gaoleijie
 * @Date 2019/4/16 11:34
 **/
@Slf4j
@Component
public class ISysUserServiceFallback implements ISysUserService {

    @Override
    public SysUserPo getUserByUserCode(String userCode) {
        log.error("请求用户服务失败");
        SysUserPo user = new SysUserPo();
        user.setUsername("fallback 回调");
        return user;
    }
}
