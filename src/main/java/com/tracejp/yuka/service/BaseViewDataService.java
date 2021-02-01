package com.tracejp.yuka.service;

import com.tracejp.yuka.model.vo.*;

import javax.servlet.http.HttpSession;

/*********************************
 * @author traceJP
 *********************************/
public interface BaseViewDataService {

    /**
     * 获取用户名服务
     * @param session 通过session获取uid
     * @return 用户名userName
     */
    String getUserName(HttpSession session);

    /**
     * 构建index页面的基本返回数据
     * @return IndexVO
     */
    IndexVO builderIndexData();

    /**
     * 构建home页面的基本返回数据
     * @param uid uid
     * @return HomeVO
     */
    HomeVO builderHomeData(String uid);

    /**
     * 构建update页面的基本返回数据
     * @param uid uid
     * @return UpdateVO
     */
    UpdateVO builderUpdateData(String uid);

    /**
     * 构建song页面的基本返回数据
     * @param musicId musicId
     * @return SongVO
     */
    SongVO builderSongData(Integer musicId);

    /**
     * 构建playlist页面的基本返回数据
     * @param musicListId musicListId
     * @return PlaylistVO
     */
    PlaylistVO builderPlaylistData(Integer musicListId);

    /**
     * 构建myMusic页面的基本返回数据
     * @param uid
     */
    void builderMyMusicData(String uid);

}
