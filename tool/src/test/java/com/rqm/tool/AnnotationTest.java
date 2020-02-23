package com.rqm.tool;

import com.rqm.tool.annotation.AnnotationModel;
import com.rqm.tool.annotation.MyAnnotation;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;

/**
 * @author renqiuming
 * @date 2020/2/23 下午10:59
 */
@SpringBootTest
public class AnnotationTest {
    @Test
    public void annotationTest(){
        Class c = AnnotationModel.class;
        for(Field f : c.getDeclaredFields()){
            // 判断这个字段是否有MyField注解
            if(f.isAnnotationPresent(MyAnnotation.class)){
                MyAnnotation annotation = f.getAnnotation(MyAnnotation.class);
                System.out.println("字段:[" + f.getName() + "], 描述:[" + annotation.description() + "], 长度:[" + annotation.length() +"]");
            }
        }
    }
}
