package com.tracejp.yuka.service.impl;

import com.tracejp.yuka.dao.UserTableMapper;
import com.tracejp.yuka.model.vo.HomeVO;
import com.tracejp.yuka.model.vo.IndexVO;
import com.tracejp.yuka.model.vo.SongVO;
import com.tracejp.yuka.model.vo.UpdateVO;
import com.tracejp.yuka.service.*;
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
    private SongPageBuilder songService;

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

    @Override
    public SongVO builderSongData(Integer musicId) {
        return songService.createSongVO(musicId);
    }


}
