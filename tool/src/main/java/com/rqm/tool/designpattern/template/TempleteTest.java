package com.rqm.tool.designpattern.template;

import com.rqm.tool.designpattern.template.order.OrderContext;
import com.rqm.tool.designpattern.template.order.OrderTemplateBuilder;
/**
 * @author renqiuming
 * @date 2020/2/3 下午12:03
 */
public class TempleteTest {
    /**
     *     要加载spring 才能测试
     */
    public static void main(String[] args) {
        OrderContext context=new OrderContext();
        context.setType(2);
        OrderTemplateBuilder.getInstance().build(context).execute(context);
        System.out.println("------next-------");
        context.setType(3);
        OrderTemplateBuilder.getInstance().build(context).execute(context);
    }
}
