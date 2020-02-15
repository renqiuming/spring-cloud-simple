package com.rqm.tool.mock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author renqiuming
 * @date 2020/2/13 下午8:12
 */
@Service
public class MockTestServiceImpl implements MockTestService {
    @Autowired
    MockService mockService;

    @Override
    public String selectMockData(String name) {
        String result= mockService.selectMockData(name);
        return result;
    }

    @Override
    public void setMockService(MockService mockService){
        this.mockService=mockService;
    }
}
