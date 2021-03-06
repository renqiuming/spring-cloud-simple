package com.rqm.tool;

import com.rqm.tool.model.User;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author renqiuming
 * @date 2020/2/11 下午4:22
 */
@SpringBootTest
public class LambdaTest {

    @Test
    public void listAndMapTest(){
        List<User> userList=buildData();
        userList.forEach(item -> System.out.println(item.getName()));
        List<Long> userIdList=userList.stream().map(User::getId).collect(Collectors.toList());
        Map<Long,String> userIdNameMap=userList.stream().collect(Collectors.toMap(User::getId,User::getName));
        userIdNameMap.forEach((key, value) ->{ System.out.println(key+value); });
        Map<String,List<User>> userNameMap=userList.stream().collect(Collectors.groupingBy(User::getName));
        int i=0;
    }

    @Test
    public void sortTest(){
        List<User> userList=buildData();
        userList.sort((a,b)-> a.getId().compareTo(b.getId()));
        userList.forEach(u->System.out.println(u.getName()));
    }

    private static List<User>  buildData(){
        List<User> userList=new ArrayList<User>();
        User u1=new User();
        u1.setId(1L);
        u1.setName("name1");
        userList.add(u1);
        User u3=new User();
        u3.setId(3L);
        u3.setName("name1");
        userList.add(u3);
        User u2=new User();
        u2.setId(2L);
        u2.setName("name2");
        userList.add(u2);
        return userList;
    }
}
