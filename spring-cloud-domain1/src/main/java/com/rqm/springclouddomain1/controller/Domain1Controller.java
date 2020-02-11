package com.rqm.springclouddomain1.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.rqm.springclouddomain1.feign.BaseService;
import com.rqm.springclouddomain1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author renqiuming
 * @date 2020/2/3 下午12:03
 */
@RestController
@RequestMapping("domain")
public class Domain1Controller {

    @Value("${config.env}")
    private String env;
    @Autowired
    private BaseService baseService;
    @Autowired
    IUserService userService;

    @RequestMapping("/domainService")
    @SentinelResource(value = "resource1", fallback = "helloError")
    /**
     * http://localhost:8763/domain/domainService?name=2
     */
    public String domain1Service(@RequestParam String name) throws Exception {
        String result = "success";
        // 测试 调用服务
        try {
            result = baseService.baseService(name + " " + env + " is service");
        } catch (Exception ex) {
            throw new Exception("远程调用失败", ex);
        }

        // 测试 连接数据库
        try {
            Object users = userService.selectById(1);
        }catch (Exception e){

        }

        return result;
    }

    public String helloError(String name, Throwable e) throws Exception {
        throw new Exception("降级失败",e);
    }
}
