package com.rqm.springclouddomain1;

import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
/**
 * @author renqiuming
 * @date 2020/2/3 下午12:03
 */
@ComponentScan("com.rqm")
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@EnableWebMvc
@MapperScan("com.rqm.springclouddomain1.mapper")
public class SpringCloudDomain1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudDomain1Application.class, args);
	}

	@Bean
	@LoadBalanced
	@SentinelRestTemplate
	RestTemplate restTemplate(){
		return new RestTemplate();
	}

}
