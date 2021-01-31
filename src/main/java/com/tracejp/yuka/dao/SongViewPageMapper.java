package com.tracejp.yuka.dao;

import com.tracejp.yuka.model.dao.SongMessageDAO;
import org.apache.ibatis.annotations.Param;

/*********************************
 * @author traceJP
 *********************************/
public interface SongViewPageMapper {

    /**
     * 通过music_id查询musicResources中对应的music信息
     * @param musicId
     * @return
     */
    SongMessageDAO selectMusicMessage(@Param("musicId") Integer musicId);

}
