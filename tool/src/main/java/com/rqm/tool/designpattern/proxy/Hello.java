package com.rqm.tool.designpattern.proxy;
/**
 * @author renqiuming
 * @date 2020/2/3 下午12:03
 */
public class Hello implements HelloInterface{
    @Override
    public void sayHello() {
        System.out.println("具体实现类!");
    }
}