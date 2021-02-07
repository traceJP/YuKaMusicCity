package com.tracejp.yuka.dao;

import com.tracejp.yuka.model.vo.MusicCollectVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*********************************
 * @author traceJP
 *********************************/
public interface MusicCollectMapper {

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


}
