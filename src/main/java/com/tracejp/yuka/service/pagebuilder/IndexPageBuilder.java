package com.tracejp.yuka.service.pagebuilder;

import com.tracejp.yuka.model.dao.IndexNewSongMusicDAO;
import com.tracejp.yuka.model.dao.IndexPopularMusicListDAO;
import com.tracejp.yuka.model.dao.IndexToDayRankMusicDAO;
import com.tracejp.yuka.model.vo.IndexVO;

/*********************************
 * @author traceJP
 *********************************/
public abstract class IndexPageBuilder {

    /**
     * 热门推荐记录返回数
     */
    protected final int POPULAR_RETURN_COUNT = 6;

    /**
     * 新歌上架记录返回数
     */
    protected final int NEW_SONG_RETURN_COUNT = 12;

    /**
     * 每日排行榜中单个排行榜记录返回数
     */
    protected final int TODAY_RANK_RETURN_COUNT = 10;


    /**
     * index页面热门推荐Service
     * @return 构建记录
     */
    protected abstract IndexPopularMusicListDAO[] popularRecommendation();

    /**
     * index页面新歌上架Service
     * @return 构建记录
     */
    protected abstract IndexNewSongMusicDAO[] newSongRecommendation();

    /**
     * index页面每日排行榜-从左往右第1个榜单Service
     * @return 构建记录
     */
    protected abstract IndexToDayRankMusicDAO[] toDayRankOne();

    /**
     * index页面每日排行榜-从左往右第2个榜单Service
     * @return 构建记录
     */
    protected abstract IndexToDayRankMusicDAO[] toDayRankTwo();

    /**
     * index页面每日排行榜-从左往右第3个榜单Service
     * @return 构建记录
     */
    protected abstract IndexToDayRankMusicDAO[] toDayRankThree();

    /**
     * 构建index页面所需要的所有数据
     * @return indexVO
     */
    public IndexVO createIndexVO() {
        return new IndexVO(
                popularRecommendation(),
                newSongRecommendation(),
                toDayRankOne(),
                toDayRankTwo(),
                toDayRankThree()
        );
    }

}
