package com.rqm.tool.designpattern.template.order.template;

import com.rqm.tool.designpattern.template.common.Context;
import com.rqm.tool.designpattern.template.common.ITemplate;
import org.springframework.stereotype.Service;
/**
 * @author renqiuming
 * @date 2020/2/3 下午12:03
 */
@Service
public class Test2OrderTemplate implements ITemplate {

    @Override
    public void execute(Context context) {
        System.out.println("Test2OrderTemplate");
    }
}
