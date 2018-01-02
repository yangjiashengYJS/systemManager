package com.slife;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ServletComponentScan(basePackages = {"com.slife.servlet"}) //添加的注解
@SpringBootApplication
@EnableAutoConfiguration
@EnableTransactionManagement
@MapperScan("com.slife.dao")//@Mapper  在mapper 接口上加入也行
public class WebApplication  extends SpringBootServletInitializer {


	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WebApplication.class);
	}


}
