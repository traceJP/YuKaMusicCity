package com.tracejp.yuka.dao;

import com.tracejp.yuka.model.dao.MyMusicUserMusicListDAO;

import java.util.List;

/*********************************
 * @author traceJP
 *********************************/
public interface MyMusicViewMapper {

    /**
     * 通过uid查询用户除默认歌单外创建的其他歌单
     * @param uid uid
     * @return MyMusicUserMusicListDAO
     */
    List<MyMusicUserMusicListDAO> selectCreateMusicList(String uid);

    /**
     * 通过uid查询用户收藏的歌单
     * @param uid uid
     * @return MyMusicUserMusicListDAO
     */
    List<MyMusicUserMusicListDAO> selectFavoritesMusicList(String uid);

    /**
     * 通过uid查询用户默认歌单的唯一标识
     * @param uid uid
     * @return Integer
     */
    Integer selectUserILikeMusicListId(String uid);




}
