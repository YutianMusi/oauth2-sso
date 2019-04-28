package com.glj.member.controller;
//
//import com.glj.model.entity.SysPermission;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MenuController
 * @Description TODO
 * @Author gaoleijie
 * @Date 2019/4/28 15:24
 **/
@RestController
public class MenuController {
    @GetMapping("/main")
    public String main(Model model) {
//        List<SysPermission> permissions = new ArrayList<>();
//        SysPermission permission = new SysPermission();
//        permission.setPid(1);
//        permission.setName("测试");
//        permission.setCode("test");
//        permission.setUri("/abc/add");
//        permissions.add(permission);

        model.addAttribute("userMenu", null);
        return "main";
    }
}
