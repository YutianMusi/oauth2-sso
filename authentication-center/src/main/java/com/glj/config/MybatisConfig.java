package com.glj.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MybatisConfig
 * @Description TODO
 * @Author gaoleijie
 * @Date 2019/3/8 15:42
 **/
@Configuration
@MapperScan("com.glj.mapper")
public class MybatisConfig {
}
