package com.tracejp.yuka.dao;

import com.tracejp.yuka.model.vo.MusicCollectVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*********************************
 * @author traceJP
 *********************************/
public interface CollectMapper {

    /**
     * 通过音乐id，歌单id，向music_list_value表中添加一条记录
     * @param musicId
     * @param listId
     */
    void insertMusicCollect(@Param("musicId") Integer musicId, @Param("listId") Integer listId);

    /**
     * 通过音乐id，歌曲id，向music_list_value表中删除一条记录
     * @param musicId
     * @param listId
     */
    void deleteMusicCollect(@Param("musicId") Integer musicId, @Param("listId") Integer listId);

    /**
     * 查询listId是否来自当前uid
     * @param listId
     * @param uid
     * @return 是则返回1，否返回0
     */
    Integer selectIsListFromUid(@Param("listId") Integer listId, @Param("uid") String uid);

    /**
     * 通过用户uid查询用户自己创建的所有歌单，并包含基本信息返回
     * @param uid
     * @return MusicCollectVO
     */
    List<MusicCollectVO> selectUserMusicList(@Param("uid") String uid);

    /**
     * 查询listId中是否存在musicId
     * @param musicId
     * @param listId
     * @return 存在返回1，不存在返回0
     */
    Integer selectListHasMusicId(@Param("musicId") Integer musicId, @Param("listId") Integer listId);



    /**
     * 通过用户id，歌单名，歌单图片url向music_list表中添加一条记录
     * @param uid
     * @param listName
     * @param imgUrl
     * @param isDefault
     */
    void insertUserMusicList(@Param("uid") String uid,
                             @Param("listName") String listName,
                             @Param("imgUrl") String imgUrl,
                             @Param("isDefault") Boolean isDefault
                             );

    /**
     * 通过歌单id删除music_list表中相应的记录
     * @param listId
     */
    void deleteUserMusicList(@Param("listId") Integer listId);
    /**
     * 通过歌单id删除music_list_value表中相应的记录
     * @param listId
     */
    void deleteUserMusicListValue(@Param("listId") Integer listId);
    /**
     * 通过歌单id删除user_keep_music_list表中相应的记录
     * @param listId
     */
    void deleteUserKeepMusicList(@Param("listId") Integer listId);
    /**
     * 删除用户保存评论（需要借助comment表进行集合的查询）
     * @param listId
     */
    void deleteUserKeepComment(@Param("listId") Integer listId);
    /**
     * 删除歌单下所有的评论（需要在删除用户保存评论后执行）
     * @param listId
     */
    void deleteMusicListComment(@Param("listId") Integer listId);

    /**
     * 通过用户id和歌单id向user_keep_music_list表中添加一条记录
     * @param uid
     * @param listId
     */
    void insertCollectMusicList(@Param("uid") String uid, @Param("listId") Integer listId);

    /**
     * 通过歌单id删除user_keep_music_list表中相应的记录
     * @param listId
     */
    void deleteCollectMusicList(@Param("listId") Integer listId);

    /**
     * 查询是否是当前用户的创建歌单
     * @param uid
     * @param listId
     * @return
     */
    Integer selectIsUserCreateMusicList(@Param("uid") String uid, @Param("listId") Integer listId);

    /**
     * 查询是否是当前用户收藏歌单
     * @param uid
     * @param listId
     * @return
     */
    Integer selectIsUserCollectMusicList(@Param("uid") String uid, @Param("listId") Integer listId);

}
