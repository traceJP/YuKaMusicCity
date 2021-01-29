package com.tracejp.yuka.service.impl;

import com.tracejp.yuka.dao.UserTableMapper;
import com.tracejp.yuka.model.vo.HomeVO;
import com.tracejp.yuka.model.vo.IndexVO;
import com.tracejp.yuka.model.vo.UpdateVO;
import com.tracejp.yuka.service.BaseViewDataService;
import com.tracejp.yuka.service.HomePageBuilder;
import com.tracejp.yuka.service.IndexPageBuilder;
import com.tracejp.yuka.service.UpdatePageBuilder;
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
    private UpdatePageBuilder updateService;

    @Autowired
    private UserTableMapper userDao;

    @Override
    public String getUserName(HttpSession session) {
        String uid = (String) session.getAttribute("uid");
        return userDao.selectUserName(uid);
    }

    @Override
    public IndexVO builderIndexData() {
        return indexService.createIndexVO();
    }

    @Override
    public HomeVO builderHomeData(String uid) {
        return homeService.createHomeVO(uid);
    }

    @Override
    public UpdateVO builderUpdateData(String uid) {
        return updateService.createUpdateVO(uid);
    }

}
