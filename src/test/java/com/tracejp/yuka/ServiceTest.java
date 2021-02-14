package com.tracejp.yuka;


import com.tracejp.yuka.service.admin.impl.UserAdminServiceImpl;
import org.junit.Test;

import java.io.File;

/*********************************
 * @author traceJP
 *********************************/
public class ServiceTest {

    @Test
    public void test() {
        String url = "..\\web\\sqlresources\\musicAudio";
        File file = new File(url);
        if(file.exists()) {
            System.out.println("存在文件");
        } else {
            System.out.println("未找到");
        }
        System.out.println(file.exists());
        System.out.println(file.getName());
    }





}
