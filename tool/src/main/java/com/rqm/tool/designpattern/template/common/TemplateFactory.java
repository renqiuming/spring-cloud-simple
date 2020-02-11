package com.rqm.tool.designpattern.template.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;
/**
 * @author renqiuming
 * @date 2020/2/3 下午12:03
 */
@Component
public class TemplateFactory implements ApplicationContextAware {
    private static Map<String, ITemplate> templateCached;
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        TemplateFactory.applicationContext = applicationContext;
    }

    public static ITemplate getBean(ITemplateType type){
        ITemplate template;
        String beanName=type.getDefaultBeanName();
        if(templateCached==null){
            templateCached=new HashMap<String, ITemplate>(200);
        }
        if(templateCached.containsKey(beanName)){
            template=templateCached.get(beanName);
        }else {
            template = (ITemplate)applicationContext.getBean(beanName);
            templateCached.put(beanName, template);
        }
        return template;
    }
    
}
