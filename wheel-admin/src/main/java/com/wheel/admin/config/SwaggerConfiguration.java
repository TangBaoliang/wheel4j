package com.wheel.admin.config;

import io.swagger.annotations.ApiModel;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Description: swagger 配置
 *
 * @author longyun
 * @version 1.0
 * @date 2022/7/29 21:24
 */
@Component
@EnableOpenApi
@ApiModel
public class SwaggerConfiguration {

    /**
     * 对C端用户的接口文档
     *
     * @return
     */
    @Bean
    public Docket webApiDoc() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("用户端接口文档")
                .pathMapping("/")
                //定义是否开启Swagger，false是关闭，可以通过变量去控制，线上关闭
                .enable(true)
                //配置文档的元信息
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.wheel.admin"))
                //正则匹配请求路径，并分配到当前项目组
                //.paths(PathSelectors.ant("/api/**"))
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("wheel管理平台")
                .description("wheel接口接口文档")
                .contact(new Contact("yun", "http://github.com/yunlong826/wheel4j/tree/develop", "1653812264@qq.com"))
                .version("v1.0")
                .build();
    }
}
