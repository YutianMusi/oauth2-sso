package com.glj.member.produce.oauth2.controller;

import com.glj.member.produce.oauth2.service.ISysUserService;
import com.glj.model.entity.SysUserPo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author gaoleijie
 * @Date 2019/4/15 20:08
 **/
@RestController
@RequestMapping("/oauth2")
@Api(tags = "用户管理")
public class SysUserController {
    @Autowired
    private ISysUserService userService;

    @PostMapping(value = "/getUserByUserCode", consumes = MediaType.APPLICATION_JSON_VALUE)
    public SysUserPo getUserByUserCode(@ApiParam("userCode") String userCode) {
        return userService.getUserByUserCode(userCode);
    }
}
