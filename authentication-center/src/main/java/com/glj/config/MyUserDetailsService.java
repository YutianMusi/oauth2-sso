package com.glj.config;

import com.alibaba.fastjson.JSON;
import com.glj.entity.SysRolePo;
import com.glj.entity.SysUserPo;
import com.glj.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    private ISysUserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUserPo sysUserPo = userService.getUserByUserCode(username);
        if (StringUtils.isEmpty(sysUserPo)) {
            log.warn("用户{}不存在", username);
            throw new UsernameNotFoundException("【" + username + "】用户不存在！");
        }
        log.info(passwordEncoder.encode(sysUserPo.getPassword()) + "原" + sysUserPo.getPassword());
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
