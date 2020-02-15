package com.rqm.tool;

import com.rqm.tool.mock.MockService;
import com.rqm.tool.mock.MockTestServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

/**
 * @author renqiuming
 * @date 2020/2/13 下午8:10
 */
@SpringBootTest
class MockTest {

    @InjectMocks
    MockTestServiceImpl mockTestService;

    @Mock
    MockService mockService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void mockTest() {
        String name = "123";
        when(mockService.selectMockData(name)).thenReturn("345");
        String result = mockTestService.selectMockData(name);
        Assert.assertEquals("345",result);
    }
}
