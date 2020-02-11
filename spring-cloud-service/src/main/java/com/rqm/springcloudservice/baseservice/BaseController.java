package com.rqm.springcloudservice.baseservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author renqiuming
 * @date 2020/2/3 下午12:03
 */
@RestController
@RequestMapping("base")
public class BaseController {
    /** http://localhost:8762/base/baseService?name=2
     *
     * @param name
     * @return
     */
    @RequestMapping("/baseService")
    public String baseService(@RequestParam String name) {
        return name;
    }
}
