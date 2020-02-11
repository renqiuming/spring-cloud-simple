package com.rqm.springclouddomain1.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * @author renqiuming
 * @date 2020/2/3 下午12:03
 */
@FeignClient(name = "service-base")
public interface BaseService {

    /**
     * baseService
     * @param name
     * @return
     */
    @RequestMapping("/base/baseService")
    public String baseService(@RequestParam("name") String name) ;
}
