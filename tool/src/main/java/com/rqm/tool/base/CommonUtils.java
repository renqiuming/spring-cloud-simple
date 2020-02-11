package com.rqm.tool.base;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author renqiuming
 * @date 2020/2/3 下午6:07
 */
public class CommonUtils {

    public static void main(String[] args) {
        // 计数器
        LongAdder count = new LongAdder();
        count.increment();
        System.out.println(count);

        // 随机数
        System.out.println(ThreadLocalRandom.current().nextInt(10));

    }
}
