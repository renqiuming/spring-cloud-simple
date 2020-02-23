package com.rqm.tool.enum1;

/**
 * @author renqiuming
 * @date 2020/2/23 下午11:07
 */
public enum MyEnum {
    AA("aa"),BB("bb");
    private String value;
    MyEnum(String value){
        this.value=value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
