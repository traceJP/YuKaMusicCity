package com.tracejp.yuka.service;

import com.tracejp.yuka.model.bo.CommentPaginationInfoBO;
import com.tracejp.yuka.model.dao.MusicCommentDAO;
import com.tracejp.yuka.model.dao.PlaylistMessageDAO;
import com.tracejp.yuka.model.dao.PlaylistMusicListElementDAO;
import com.tracejp.yuka.model.vo.PlaylistVO;

/*********************************
 * @author traceJP
 *********************************/
public abstract class PlaylistPageBuilder {

    /**
     * 根据歌单id构建整个页面
     */
    protected Integer musicListId;

    /**
     * 本抽象类为构建以歌曲为主的页面，type值为 2
     */
    protected final Integer DEFAULT_TYPE = 2;

    /**
     * 默认评论为第一页，值为 1
     */
    protected final Integer DEFAULT_PAGE = 1;


    /**
     * playlist页面歌单信息模块Service
     * @return 歌单描述信息
     */
    protected abstract PlaylistMessageDAO playlistMessage();

    /**
     * playlist页面歌单中的歌曲表格Service
     * @return
     */
    protected abstract PlaylistMusicListElementDAO[] musicListMessage();

    /**
     * playlist页面构建评论分页的基础信息
     * @return
     */
    protected abstract CommentPaginationInfoBO paginationInfo();

    /**
     * playlist页面获取默认评论第一页的信息
     * @return
     */
    protected abstract MusicCommentDAO[] songCommentDefaultElementList();

    /**
     * 获取歌单中总共有多少首歌
     * @return
     */
    protected Integer getMusicCount(PlaylistMusicListElementDAO[] array) {
        return array.length;
    }

    /**
     * 构建playlist页面所需要的所有数据
     */
    public PlaylistVO createPlaylistVO(Integer musicListId) {
        this.musicListId = musicListId;
        PlaylistMusicListElementDAO[] array = musicListMessage();
        return new PlaylistVO(
                playlistMessage(),
                array,
                getMusicCount(array),
                songCommentDefaultElementList(),
                paginationInfo()
        );
    }

}
