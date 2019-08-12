package com.liuhq.system.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 启动类
 */
/*
 * 为什么要排除DruidDataSourceAutoConfigure ？
 * DruidDataSourceAutoConfigure会注入一个DataSourceWrapper，其会在原生的spring.datasource下找url,username,password等。而我们动态数据源的配置路径是变化的。
 */
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
@MapperScan(basePackages = { "com.liuhq.system.dao" })
@ComponentScan(basePackages = {"com.liuhq.system"})
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class ApplicationStart {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationStart.class, args);
	}

}
