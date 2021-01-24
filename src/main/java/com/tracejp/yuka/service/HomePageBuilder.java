package com.tracejp.yuka.service;

import com.tracejp.yuka.model.bo.HomeUserInfomationBO;
import com.tracejp.yuka.model.bo.HomeUserLevelBO;
import com.tracejp.yuka.model.vo.HomeVO;

/*********************************
 * @author traceJP
 *********************************/
public abstract class HomePageBuilder {

    /**
     * 查询当前home页面中uid的资料
     */
    protected String userUid;

    /**
     * home页面 个人资料Service
     * @return HomeUserInfomationBO
     */
    protected HomeUserInfomationBO personalInformation() {
        return null;
    }

    /**
     * home页面 我的等级Service
     * @return HomeUserLevelBO
     */
    protected HomeUserLevelBO myGrade() {
        return null;
    }

    /**
     * home页面 听歌排行榜Service
     * @return HomeListenToSongsRankBO
     */
    protected HomeListenToSongsRankBO listenToSongsRank() {
        return null;
    }

    /**
     * 构建home页面需要的所有数据
     * @param uid 该信息来源uid
     * @return HomeVO
     */
    public HomeVO createHomeVO(String uid) {
        userUid = uid;
        return new HomeVO(
                personalInformation(),
                myGrade(),
                listenToSongsRank()
        );
    }

}
