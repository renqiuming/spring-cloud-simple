package com.rqm.tool.designpattern.template.common;
import java.util.ArrayList;
import java.util.List;
/**
 * @author renqiuming
 * @date 2020/2/3 下午12:03
 */
public class CompositeTemplate {
    public List<ITemplate> templates=new ArrayList<ITemplate>();

    public boolean add(ITemplateType type) {
        ITemplate template = TemplateFactory.getBean(type);
        if (null != template) {
            this.templates.add(template);
            return true;
        }
        return false;
    }
    public void execute(Context context) {
        for (ITemplate template : this.templates) {
            template.execute(context);
        }
    }
}
