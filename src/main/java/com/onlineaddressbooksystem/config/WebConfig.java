package com.onlineaddressbooksystem.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Slf4j
@Configuration
@EnableSwagger2WebMvc
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
    /**
     * Swagger2 配置
     * @return Docket
     */
    @Bean(value = "dockerBean")
    public Docket dockerBean() {
        log.info("Swagger2 init ...");
        return new Docket(DocumentationType.SWAGGER_2) // 指定使用 Swagger2 规范
                .apiInfo(new ApiInfoBuilder()
                        // 描述字段支持 Markdown 语法
                        .description("# Online Address Book System REST-ful APIs")
                        .termsOfServiceUrl("https://link_not_exist.com/")
                        .version("1.0")
                        .build())
                // 分组名称
                // .groupName("group 1")
                .select()
                // 指定 Controller 扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.onlineaddressbooksystem.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
