package com.rqm.tool;

import com.rqm.tool.designpattern.callback.CallbackHandle;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author renqiuming
 * @date 2020/2/23 下午10:35
 */
@SpringBootTest
public class CallbackTest {

    @Test
    public void callbackTest() {
        CallbackHandle callbackHandle = new CallbackHandle();
        callbackHandle.handle("test", () -> {
            System.out.println("回调方法");
        });
    }

}
