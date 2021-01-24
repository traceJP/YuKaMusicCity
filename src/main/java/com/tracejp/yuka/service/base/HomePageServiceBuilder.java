package com.tracejp.yuka.service.base;

import com.tracejp.yuka.dao.HomeViewPageMapper;
import com.tracejp.yuka.model.bo.HomeUserInfomationBO;
import com.tracejp.yuka.model.bo.HomeUserLevelBO;
import com.tracejp.yuka.service.HomePageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*********************************
 * @author traceJP
 *********************************/
@Service
public class HomePageServiceBuilder extends HomePageBuilder {

    @Autowired
    HomeViewPageMapper viewPage;

    @Override
    protected HomeUserInfomationBO personalInformation() {

        return null;
    }

    @Override
    protected HomeUserLevelBO myGrade() {

        return null;
    }

    @Override
    protected HomeListenToSongsRankBO listenToSongsRank() {

        return null;
    }

}
