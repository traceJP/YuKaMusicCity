package com.tracejp.yuka.service;

import com.tracejp.yuka.model.dao.IndexNewSongMusicDAO;
import com.tracejp.yuka.model.dao.IndexPopularMusicListDAO;
import com.tracejp.yuka.model.dao.IndexToDayRankMusicDAO;

/*********************************
 * @author traceJP
 *********************************/
public interface IndexPageService {

    /**
     * 热门推荐记录返回数
     */
    int POPULAR_RETURN_COUNT = 6;

    /**
     * 新歌上架记录返回数
     */
    int NEW_SONG_RETURN_COUNT = 12;

    /**
     * 每日排行榜中单个排行榜记录返回数
     */
    int TODAY_RANK_RETURN_COUNT = 10;


    /**
     * index页面热门推荐Service
     * @return 构建记录
     */
    IndexPopularMusicListDAO[] popularRecommendation();

    /**
     * index页面新歌上架Service
     * @return 构建记录
     */
    IndexNewSongMusicDAO[] newSongRecommendation();

    /**
     * index页面每日排行榜-从左往右第1个榜单Service
     * @return 构建记录
     */
    IndexToDayRankMusicDAO[] toDayRankOne();

    /**
     * index页面每日排行榜-从左往右第2个榜单Service
     * @return 构建记录
     */
    IndexToDayRankMusicDAO[] toDayRankTwo();

    /**
     * index页面每日排行榜-从左往右第3个榜单Service
     * @return 构建记录
     */
    IndexToDayRankMusicDAO[] toDayRankThree();

}
