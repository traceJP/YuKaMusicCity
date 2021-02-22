package com.tracejp.yuka;


import com.tracejp.yuka.model.bo.HomeListenToSongsBO;
import com.tracejp.yuka.model.dao.HomeListenToSongsDAO;
import com.tracejp.yuka.service.admin.impl.UserAdminServiceImpl;
import com.tracejp.yuka.utils.Util;
import org.junit.Test;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/*********************************
 * @author traceJP
 *********************************/
public class ServiceTest {

    @Test
    public void test() {

        long overTime = Util.getOneDayEndTime();
        long cut = System.currentTimeMillis();
        System.out.println(overTime);
        System.out.println(cut);
        System.out.println((overTime - cut) /  1000);


    }






}
