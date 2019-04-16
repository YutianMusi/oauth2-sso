package com.glj.service;


import com.glj.config.fallback.ISysUserServiceFallback;
import com.glj.config.fulllog.FullLogConfiguration;
import com.glj.model.entity.SysUserPo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author gaoleijie
 * @since 2019-01-11
 */
@FeignClient(serviceId = "oauth2-sso-client-member-produce", fallback = ISysUserServiceFallback.class, configuration = FullLogConfiguration.class, path = "/oauth2")
public interface ISysUserService {
    @PostMapping(value = "/getUserByUserCode", consumes = MediaType.APPLICATION_JSON_VALUE)
    SysUserPo getUserByUserCode(@RequestParam("userCode") String userCode);
}
