package com.tracejp.yuka.dao;

import com.tracejp.yuka.model.dao.PlaylistMessageDAO;
import com.tracejp.yuka.model.dao.PlaylistMusicListElementDAO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*********************************
 * @author traceJP
 *********************************/
public interface PlaylistViewMapper {

    /**
     * 通过歌单id查询歌单的基本展示信息
     * @param id id
     * @return PlaylistMessageDAO
     */
    PlaylistMessageDAO selectPlaylistMessage(@Param("id") Integer id);

    /**
     * 通过歌单id查询该歌单下所有歌曲的信息
     * @param id id
     * @return PlaylistMusicListElementDAO
     */
    List<PlaylistMusicListElementDAO> selectPlaylistMusicList(@Param("id") Integer id);

}
