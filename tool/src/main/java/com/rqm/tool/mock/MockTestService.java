package com.rqm.tool.mock;

/**
 * @author renqiuming
 * @date 2020/2/13 下午8:12
 */
public interface MockTestService {
    String selectMockData(String name);
    void setMockService(MockService mockService);
}
