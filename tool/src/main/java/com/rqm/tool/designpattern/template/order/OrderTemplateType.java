package com.rqm.tool.designpattern.template.order;

import com.rqm.tool.designpattern.template.common.ITemplateType;
/**
 * @author renqiuming
 * @date 2020/2/3 下午12:03
 */
public enum OrderTemplateType implements ITemplateType {
    /**
     * TEST1
     */
    TEMPLATE1(100, "test1OrderTemplate", "TEST1"),
    /**
     * TEST2
     */
    TEMPLATE2(200, "test2OrderTemplate", "TEST2"),
    /**
     * TEST3
     */
    TEMPLATE3(300, "test3OrderTemplate", "TEST3");

    /**
     * 值
     */
    private int value;
    /***
     * bean name
     */
    private String defaultBeanName;
    /**
     * 描述
     */
    private String description;
    /**
     * 值
     */
    @Override
    public int getValue() {
        return value;
    }
    /***
     * bean name
     */
    @Override
    public String getDefaultBeanName() {
        return defaultBeanName;
    }
    /**
     * 描述
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * 订单模板类型
     * @param value 11
     * @param defaultBeanName 11
     * @param description 11
     */
    OrderTemplateType(int value, String defaultBeanName, String description) {
        this.value = value;
        this.defaultBeanName = defaultBeanName;
        this.description = description;
    }
}
