package com.tracejp.yuka.service.impl;

import com.tracejp.yuka.dao.UserTableMapper;
import com.tracejp.yuka.model.vo.IndexVO;
import com.tracejp.yuka.service.BaseViewDataService;
import com.tracejp.yuka.service.HomePageService;
import com.tracejp.yuka.service.IndexPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/*********************************
 * @author traceJP
 *********************************/
@Service
public class BaseViewDataServiceImpl implements BaseViewDataService {

    @Autowired
    private IndexPageService indexService;

    @Autowired
    private HomePageService homeService;

    @Autowired
    private UserTableMapper userDao;

    public String getUserName(HttpSession session) {
        String uid = (String) session.getAttribute("uid");
        userDao.selectUserName(uid);
        return uid;
    }

    // TODO: 2021/1/24 在建造者模式下 service层应该调用指挥类，而不是直接调用各方法
    public IndexVO builderIndexData() {
        return new IndexVO(indexService.popularRecommendation(),
                indexService.newSongRecommendation(),
                indexService.toDayRankOne(),
                indexService.toDayRankTwo(),
                indexService.toDayRankThree()
        );
    }
}
