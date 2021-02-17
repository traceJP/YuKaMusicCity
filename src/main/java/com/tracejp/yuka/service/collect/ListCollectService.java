package com.tracejp.yuka.service.collect;

import org.springframework.web.multipart.MultipartFile;

/*********************************
 * @author traceJP
 *********************************/
public interface ListCollectService {

    /**
     * 新建歌单
     * @param uid 用户id
     * @param listName 歌单名
     * @param fileImg 歌单展示图片封装类
     * @return
     */
    String addUserMusicList(String uid, String listName, String listType, MultipartFile fileImg);

    /**
     * 通过歌单id和用户id删除歌单
     * @param uid
     * @param listId
     * @return 成功返回200， 否则返回返回404
     */
    String removeUserMusicList(String uid, Integer listId);

    /**
     * 新增收藏歌单
     * @param uid
     * @param listId
     * @return 成功返回200， 否则返回返回404
     */
    String addUserCollectMusicList(String uid, Integer listId);

    /**
     * 取消收藏歌单
     * @param uid
     * @param listId
     * @return
     */
    String removeUserCollectMusicList(String uid, Integer listId);

    /**
     * 查询是否是当前用户的创建歌单
     * @param uid 用户id
     * @param listId 歌单id
     * @return 是返回true，否返回false
     */
    Boolean isUserCreateMusicList(String uid, Integer listId);

    /**
     * 查询是否是当前用户收藏歌单
     * @param uid 用户id
     * @param listId 歌单id
     * @return 是返回true，否返回false
     */
    Boolean isUserCollectMusicList(String uid, Integer listId);

}
