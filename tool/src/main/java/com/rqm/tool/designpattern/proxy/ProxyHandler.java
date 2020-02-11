package com.rqm.tool.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/**
 * @author renqiuming
 * @date 2020/2/3 下午12:03
 */
public class ProxyHandler implements InvocationHandler {
    private Object object;
    public ProxyHandler(Object object){
        this.object = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("test Before invoke "  + method.getName());
        method.invoke(object, args);
        System.out.println("test After invoke " + method.getName());
        return null;
    }
}