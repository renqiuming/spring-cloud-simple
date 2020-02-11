package com.rqm.tool.designpattern.singleton;

/**
 * @author renqiuming
 * @date 2020/2/3 下午5:15
 */
public class Singleton {
    volatile private static Singleton instance = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
