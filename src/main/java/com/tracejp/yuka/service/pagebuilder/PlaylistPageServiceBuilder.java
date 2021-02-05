package com.tracejp.yuka.service.pagebuilder;

import com.tracejp.yuka.dao.PlaylistViewMapper;
import com.tracejp.yuka.model.bo.CommentPaginationInfoBO;
import com.tracejp.yuka.model.dao.MusicCommentDAO;
import com.tracejp.yuka.model.dao.PlaylistMessageDAO;
import com.tracejp.yuka.model.dao.PlaylistMusicListElementDAO;
import com.tracejp.yuka.service.comment.impl.CommentServiceImpl;
import com.tracejp.yuka.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*********************************
 * @author traceJP
 *********************************/
@Service
public class PlaylistPageServiceBuilder extends PlaylistPageBuilder {

    @Autowired
    CommentServiceImpl commentService;

    @Autowired
    PlaylistViewMapper viewPage;


    @Override
    protected PlaylistMessageDAO playlistMessage() {
        return viewPage.selectPlaylistMessage(musicListId);
    }

    @Override
    protected PlaylistMusicListElementDAO[] musicListMessage() {
        List<PlaylistMusicListElementDAO> list = viewPage.selectPlaylistMusicList(musicListId);
        return (PlaylistMusicListElementDAO[]) Util.ListTransformArray(list);
    }

    @Override
    protected CommentPaginationInfoBO paginationInfo() {
        int elementCount = commentService.getElementCount(musicListId, DEFAULT_TYPE);
        int paginationCount = commentService.getPaginationCount(elementCount);
        return new CommentPaginationInfoBO(elementCount,paginationCount);
    }

    @Override
    protected MusicCommentDAO[] songCommentDefaultElementList() {
        List<MusicCommentDAO> list = commentService.getPaginationService(DEFAULT_PAGE, musicListId, DEFAULT_TYPE);
        return (MusicCommentDAO[]) Util.ListTransformArray(list);
    }

}
