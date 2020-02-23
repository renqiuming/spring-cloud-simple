package com.rqm.tool.designpattern.callback;

/**
 * @author renqiuming
 * @date 2020/2/23 下午10:33
 */
public class CallbackHandle {
    public void handle(String msg, ICallback callBack) {
        System.out.println("接收到的msg = " + msg);
        // 调用回调方法
        callBack.onResponse();
    }

}
