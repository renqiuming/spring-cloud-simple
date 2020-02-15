package com.rqm.tool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author renqiuming
 * @date 2020/2/3 下午12:03
 */
@SpringBootApplication
@ComponentScan("com.rqm.tool")
public class ToolApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToolApplication.class, args);
	}

}
