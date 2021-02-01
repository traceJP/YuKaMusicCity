package com.tracejp.yuka.service.base;

import com.tracejp.yuka.dao.PlaylistViewMapper;
import com.tracejp.yuka.model.bo.CommentPaginationInfoBO;
import com.tracejp.yuka.model.dao.MusicCommentDAO;
import com.tracejp.yuka.model.dao.PlaylistMessageDAO;
import com.tracejp.yuka.model.dao.PlaylistMusicListElementDAO;
import com.tracejp.yuka.service.PlaylistPageBuilder;
import com.tracejp.yuka.service.impl.CommentServiceImpl;
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
        if(list == null) {
            return null;
        }
        int listSize = list.size();
        return list.toArray(new PlaylistMusicListElementDAO[listSize]);
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
        if(list == null) {
            return null;
        }
        return list.toArray(new MusicCommentDAO[CommentServiceImpl.elementReturnCount]);
    }

}
