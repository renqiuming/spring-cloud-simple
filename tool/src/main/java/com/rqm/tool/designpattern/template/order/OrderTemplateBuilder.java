package com.rqm.tool.designpattern.template.order;

import com.rqm.tool.designpattern.template.common.CompositeTemplate;
import com.rqm.tool.designpattern.template.common.Context;
import com.rqm.tool.designpattern.template.common.ITemplateBuilder;

/**
 * @author renqiuming
 * @date 2020/2/3 下午12:03
 */
public class OrderTemplateBuilder implements ITemplateBuilder {
    private volatile static OrderTemplateBuilder instance = null;

    public static OrderTemplateBuilder getInstance() {
        if (null == instance) {
            synchronized (OrderTemplateBuilder.class) {
                if (null == instance) {
                    instance = new OrderTemplateBuilder();
                }
            }
        }
        return instance;
    }

    @Override
    public CompositeTemplate build(Context context) {
        CompositeTemplate compositeTemplate = new CompositeTemplate();
        switch (context.getType()) {
            case 2:
                compositeTemplate.add(OrderTemplateType.TEMPLATE1);
                compositeTemplate.add(OrderTemplateType.TEMPLATE2);
                break;
            case 3:
                compositeTemplate.add(OrderTemplateType.TEMPLATE1);
                compositeTemplate.add(OrderTemplateType.TEMPLATE2);
                compositeTemplate.add(OrderTemplateType.TEMPLATE3);
                break;
            default:
        }
        return compositeTemplate;
    }

}
