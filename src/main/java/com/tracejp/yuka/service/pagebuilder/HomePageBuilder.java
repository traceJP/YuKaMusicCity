package com.tracejp.yuka.service.pagebuilder;

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
    protected abstract HomeUserInfomationBO personalInformation();

    /**
     * home页面 我的等级Service
     * @return HomeUserLevelBO
     */
    protected abstract HomeUserLevelBO myGrade();

    /**
     * home页面 听歌排行榜Service
     * @return HomeListenToSongsRankBO
     */
    protected abstract HomeListenToSongsBO[] listenToSongsRank();

    /**
     * 查询时进行用户的升级判断
     */
    protected abstract void userUpgrade();

    /**
     * 构建home页面需要的所有数据
     * @param uid 该信息来源uid
     * @return HomeVO
     */
    public HomeVO createHomeVO(String uid) {
        userUid = uid;
        userUpgrade();
        return new HomeVO(
                personalInformation(),
                myGrade(),
                listenToSongsRank()
        );
    }

}
