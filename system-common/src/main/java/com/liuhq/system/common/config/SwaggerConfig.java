package com.liuhq.system.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger2配置类
 */
@Configuration
public class SwaggerConfig {

	/**
	 * swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
	 */
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(new ApiInfoBuilder()
				// 页面标题
				.title("xxx系统RESTFUL API")
				// 创建人
				.contact(new Contact("liuhq", "http://www.baidu.com/", "897468991@qq.com"))
				// 版本号
				.version("1.0")
				// 描述
				.description("xxx系统API v1.0").build()).select()
				// 扫描controoler包
				.apis(RequestHandlerSelectors.basePackage("com.liuhq.system.admin.controller"))
				.paths(PathSelectors.any()).build();
	}

}
