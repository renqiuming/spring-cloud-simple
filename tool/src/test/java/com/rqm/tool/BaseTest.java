package com.rqm.tool;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author renqiuming
 * @date 2020/2/11 下午4:09
 */
@SpringBootTest
public class BaseTest {

    @Test
    public void randomTest(){
        // 计数器
        LongAdder count = new LongAdder();
        count.increment();
        System.out.println(count);

        // 随机数
        System.out.println(ThreadLocalRandom.current().nextInt(10));

    }

}
