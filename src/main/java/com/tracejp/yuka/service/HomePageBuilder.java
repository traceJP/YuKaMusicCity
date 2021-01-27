package com.tracejp.yuka.service;

import com.tracejp.yuka.model.bo.HomeListenToSongsBO;
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
     * 听歌排行榜记录返回数
     */
    protected final int RANK_RETURN_COUNT = 10;

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
    protected HomeListenToSongsBO[]   listenToSongsRank() {
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
