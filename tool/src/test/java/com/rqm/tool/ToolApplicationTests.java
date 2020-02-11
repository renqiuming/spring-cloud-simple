package com.rqm.tool;

import com.rqm.tool.designpattern.proxy.Hello;
import com.rqm.tool.designpattern.proxy.HelloInterface;
import com.rqm.tool.designpattern.proxy.ProxyHandler;
import com.rqm.tool.designpattern.template.order.OrderContext;
import com.rqm.tool.designpattern.template.order.OrderTemplateBuilder;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

@SpringBootTest
class ToolApplicationTests {

	//@Test
	void TempleteTest() {
		OrderContext context=new OrderContext();
		context.setType(2);
		OrderTemplateBuilder.getInstance().build(context).execute(context);
		System.out.println("------next-------");
		context.setType(3);
		OrderTemplateBuilder.getInstance().build(context).execute(context);
	}


	//@Test
	void TempleteProxy() {
		System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		HelloInterface hello = new Hello();
		InvocationHandler handler = new ProxyHandler(hello);
		HelloInterface proxyHello = (HelloInterface) Proxy.newProxyInstance(hello.getClass().getClassLoader(), hello.getClass().getInterfaces(), handler);
		proxyHello.sayHello();
	}


}
