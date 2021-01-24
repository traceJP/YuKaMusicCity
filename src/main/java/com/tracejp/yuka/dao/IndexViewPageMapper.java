package com.tracejp.yuka.dao;

import com.tracejp.yuka.model.dao.IndexNewSongMusicDAO;
import com.tracejp.yuka.model.dao.IndexPopularMusicListDAO;
import com.tracejp.yuka.model.dao.IndexToDayRankMusicDAO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*********************************
 * @author traceJP
 *********************************/
// TODO: 2021/1/23 需要重构 dao层接口改名以对应service层中base包中的类
public interface IndexViewPageMapper {

    /**
     * 向music_list表中查询以歌单播放数为升序的记录
     * @param resultCount 返回记录个数
     * @return IndexPopularMusicListDAO
     */
    List<IndexPopularMusicListDAO> getMusicListBaseInfoToPopular(@Param("resultCount") Integer resultCount);

    /**
     * 向music_resources表中查询以创建时间为升序的记录
     * @param resultCount 返回记录个数
     * @return IndexNewSongMusicDAO
     */
    List<IndexNewSongMusicDAO> getMusicBaseInfoToNewSong(@Param("resultCount") Integer resultCount);

    /**
     * 向向music_resources表中查询以 随机记录返回
     * @param resultCount 返回记录个数
     * @return
     */
    List<IndexToDayRankMusicDAO> getMusicBaseInfoToRankMusic(@Param("resultCount") Integer resultCount);


}
