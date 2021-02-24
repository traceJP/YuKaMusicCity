package com.tracejp.yuka.dao;

import org.apache.ibatis.annotations.Param;

/*********************************
 * @author traceJP
 *********************************/
public interface BehaviorMapper {

    /**
     * 通过歌曲id和uid查询对应UserSongLeaderboard表是否存在记录
     * @param uid 用户id
     * @param id 歌曲唯一标识id
     * @return 存在则返回对应的数量，不存在返回null
     */
    Integer selectUserMusicBroadcastNumber(@Param("id") Integer id, @Param("uid") String uid);

    /**
     * 通过歌曲id和uid向UserSongLeaderboard表中新增一条记录
     * 如果存在记录则将原记录broadcast_number_times字段原值+1
     * @param uid 用户id
     * @param id 歌曲唯一标识id
     * @param number 原记录数量
     */
    void insertUserMusicBroadcastNumber(@Param("id") Integer id, @Param("number") Integer number, @Param("uid")String uid);

    /**
     * 通过歌单id使music_list表中music_list_play_count字段自增1
     * @param id
     */
    void updateMusicListPlayCount(@Param("id") Integer id);


}
