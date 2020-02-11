package com.rqm.springclouddomain1.utils;

import com.alibaba.csp.sentinel.slots.block.BlockException;

import java.util.HashMap;
import java.util.Map;
/**
 * @author renqiuming
 * @date 2020/2/3 下午12:03
 */
public class ExceptionUtil {

    /**  java -jar sentinel-dashboard.jar
     *     http://localhost:8080/
    */
    public static Map<String,Object> handleException(BlockException ex) {
        Map<String,Object> map=new HashMap<>(200);
        map.put("Oops",ex.getClass().getCanonicalName());
        map.put("msg","通过@SentinelResource注解配置限流埋点并自定义处理限流后的逻辑");
        return  map;
    }
}
