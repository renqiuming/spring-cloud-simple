package com.rqm.tool.mock;

import org.springframework.stereotype.Service;

/**
 * @author renqiuming
 * @date 2020/2/13 下午8:12
 */
@Service
public class MockServiceImpl implements MockService{
    @Override
    public String selectMockData(String name) {
        return "mock"+name;
    }
}
