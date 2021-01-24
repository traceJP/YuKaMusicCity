package com.tracejp.yuka.service.impl;

import com.tracejp.yuka.dao.UserTableMapper;
import com.tracejp.yuka.model.vo.HomeVO;
import com.tracejp.yuka.model.vo.IndexVO;
import com.tracejp.yuka.service.BaseViewDataService;
import com.tracejp.yuka.service.HomePageBuilder;
import com.tracejp.yuka.service.IndexPageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/*********************************
 * @author traceJP
 *********************************/
@Service
public class BaseViewDataServiceImpl implements BaseViewDataService {

    @Autowired
    private IndexPageBuilder indexService;

    @Autowired
    private HomePageBuilder homeService;

    @Autowired
    private UserTableMapper userDao;

    public String getUserName(HttpSession session) {
        String uid = (String) session.getAttribute("uid");
        userDao.selectUserName(uid);
        return uid;
    }

    public IndexVO builderIndexData() {
        return indexService.createIndexVO();
    }

    public HomeVO builderHomeData(String uid) {
        return homeService.createHomeVO(uid);
    }



}
