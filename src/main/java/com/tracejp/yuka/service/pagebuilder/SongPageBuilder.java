package com.tracejp.yuka.service.pagebuilder;

import com.tracejp.yuka.model.bo.CommentPaginationInfoBO;
import com.tracejp.yuka.model.dao.MusicCommentDAO;
import com.tracejp.yuka.model.dao.SongMessageDAO;
import com.tracejp.yuka.model.vo.SongVO;

/*********************************
 * @author traceJP
 *********************************/
public abstract class SongPageBuilder {

    /**
     * 根据歌曲id构建整个页面
     */
    protected Integer musicId;

    /**
     * 本抽象类为构建以歌曲为主的页面，type值为 1
     */
    protected final Integer DEFAULT_TYPE = 1;

    /**
     * 默认评论为第一页，值为 1
     */
    protected final Integer DEFAULT_PAGE = 1;

    /**
     * song页面构建歌曲信息模块Service
     * @return SongMessageDAO
     */
    protected abstract SongMessageDAO songMessage();

    /**
     * song页面构建评论分页的基础信息
     * @return
     */
    protected abstract CommentPaginationInfoBO paginationInfo();

    /**
     * song页面获取默认评论第一页的信息
     * @return
     */
    protected abstract MusicCommentDAO[] songCommentDefaultElementList();

    /**
     * 构建song页面所需要的所有数据
     * @param musicId musicId
     */
    public SongVO createSongVO(Integer musicId) {
        this.musicId = musicId;
        return new SongVO(
                songMessage(),
                songCommentDefaultElementList(),
                paginationInfo()
        );
    }

}
