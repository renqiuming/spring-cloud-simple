package com.rqm.tool.generics;

/**
 * @author renqiuming
 * @date 2020/2/15 下午2:05
 */
public class GenericClass <T> {
    private T generic;

    public void init(T t){
        generic=t;
    }

    public T getGeneric(){
        return generic;
    }
}
