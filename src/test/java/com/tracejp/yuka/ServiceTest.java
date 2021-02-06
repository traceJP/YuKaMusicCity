package com.tracejp.yuka;

import com.tracejp.yuka.model.vo.SearchVO;
import com.tracejp.yuka.service.search.SearchStrategy;
import com.tracejp.yuka.service.search.impl.SongSearch;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*********************************
 * @author traceJP
 *********************************/
public class ServiceTest {

    @Test
    public void test() {

        List<String> list = new LinkedList<>();
        list.add("123");
        list.add("123");
        list.add("123");

        String[] a = new String[0];

        // 通过util方法转化为数组
        ListTransformArray(list, a);


        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

    }

    // list转化为数组的util方法，判空方法
    public void ListTransformArray(List list, Object[] array) {
        if(list == null) {
            return;
        }
        list.toArray(array);
    }



}
