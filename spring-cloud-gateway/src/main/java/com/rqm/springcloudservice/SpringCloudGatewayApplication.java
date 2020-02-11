package com.rqm.springcloudservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;
/**
 * @author renqiuming
 * @date 2020/2/3 下午12:03
 */
@EnableZuulProxy
@SpringBootApplication
public class SpringCloudGatewayApplication {
	/**
	 * http://localhost:8765/apigateway/base/baseService?name=2
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudGatewayApplication.class, args);
	}

}
