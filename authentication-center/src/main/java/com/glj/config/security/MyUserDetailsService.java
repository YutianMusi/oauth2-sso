package com.glj.config.security;
import com.alibaba.fastjson.JSON;
import com.glj.model.entity.SysRolePo;
import com.glj.model.entity.SysUserPo;
import com.glj.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MyUserDetailsService
 * @Description TODO
 * @Author gaoleijie
 * @Date 2019/4/4 14:32
 **/
@Service
@Slf4j
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ISysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUserPo sysUserPo = sysUserService.getUserByUserCode(username);
        if (StringUtils.isEmpty(sysUserPo)) {
            log.warn("用户{}不存在", username);
            throw new UsernameNotFoundException("【" + username + "】用户不存在！");
        }
        if (sysUserPo.getStatus() == 0) {
            log.warn("用户{}被冻结", username);
            throw new LockedException("【" + username + "】用户被冻结，无法登陆！");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (SysRolePo role : sysUserPo.getRolePoList()) {
            role.getPermissionPoList().stream().forEach(d -> {
                authorities.add(new SimpleGrantedAuthority(d.getCode()));
            });
        }
        log.info("登录成功！用户: {}", JSON.toJSONString(sysUserPo));
        return new User(sysUserPo.getUsername(), passwordEncoder.encode(sysUserPo.getPassword()), authorities);
    }
}
