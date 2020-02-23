package com.rqm.tool;

import com.rqm.tool.designpattern.callback.CallbackHandle;
import com.rqm.tool.enum1.MyEnum;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author renqiuming
 * @date 2020/2/23 下午10:35
 */
@SpringBootTest
public class EnumTest {

    @Test
    public void enumTest() {
        System.out.println("枚举"+ MyEnum.AA);
    }

}
