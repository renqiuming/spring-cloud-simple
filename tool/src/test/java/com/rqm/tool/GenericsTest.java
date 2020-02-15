package com.rqm.tool;

import com.rqm.tool.generics.GenericClass;
import com.rqm.tool.model.User;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author renqiuming
 * @date 2020/2/15 下午2:09
 */
@SpringBootTest
public class GenericsTest {

    @Test
    public void getGenericTest(){
        User user=new User();
        user.setName("u");
        GenericClass<User> a=new GenericClass();
        a.init(user);
        System.out.println(a.getGeneric().getName());
    }

}
