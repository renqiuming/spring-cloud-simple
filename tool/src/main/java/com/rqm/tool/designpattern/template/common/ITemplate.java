package com.rqm.tool.designpattern.template.common;
/**
 * @author renqiuming
 * @date 2020/2/3 下午12:03
 */
public interface ITemplate {
    /**
     * build
     * @param context
     */
    void execute(Context context);
}
