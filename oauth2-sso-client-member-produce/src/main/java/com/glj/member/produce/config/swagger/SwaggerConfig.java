package com.glj.member.produce.config.swagger;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger2.enable}")
    private boolean enable;//是否开启swaager，如果生产环境，则禁止

    //如果不需要进行模块区分，直接用默认模块即可
    @Bean("默认模块")
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("默认模块")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.glj.member.produce"))//Swagger Api扫描包路径
                .paths(PathSelectors.any())
                .build();
    }

    @Bean("用户模块")
    public Docket createUserApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("用户模块")
                .select()
                //.apis(RequestHandlerSelectors.basePackage("com.glj.member.produce"))//Swagger Api扫描包路径
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.regex("/oauth2.*"))
                .build()
                .apiInfo(apiInfo())
                .enable(enable);//是否开启
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SpringBoot 整合Swagger")//Ui页面Title
                .description("KXL oauth2-sso-client-member-produce  API") //说明
                .termsOfServiceUrl("https://www.jianshu.com/nb/35744583")//自己或者单位的官方服务地址
                .version("2.0")//版本
                .build();
    }

}
