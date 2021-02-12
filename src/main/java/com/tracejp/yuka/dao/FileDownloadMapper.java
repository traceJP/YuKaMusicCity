package com.tracejp.yuka.dao;

import java.util.List;

/*********************************
 * @author traceJP
 *********************************/
public interface FileDownloadMapper {

    /**
     * 通过音乐id查询对应的歌曲url
     * @param id
     * @return
     */
    String selectMusicResourcesUrl(Integer id);

    /**
     * 通过歌单id查询对应的歌曲url集合
     * @param id
     * @return
     */
    List<String> selectMusicResourcesUrlByList(Integer id);

    /**
     * 通过歌单id查询对应的歌单名
     * @param id
     * @return
     */
    String selectMusicListName(Integer id);

}
