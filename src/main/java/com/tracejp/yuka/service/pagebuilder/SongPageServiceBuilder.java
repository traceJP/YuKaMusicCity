package com.tracejp.yuka.service.pagebuilder;

import com.tracejp.yuka.dao.SongViewPageMapper;
import com.tracejp.yuka.model.bo.CommentPaginationInfoBO;
import com.tracejp.yuka.model.dao.MusicCommentDAO;
import com.tracejp.yuka.model.dao.SongMessageDAO;
import com.tracejp.yuka.service.comment.impl.CommentServiceImpl;
import com.tracejp.yuka.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

/*********************************
 * @author traceJP
 *********************************/
@Service
@RequestScope
public class SongPageServiceBuilder extends SongPageBuilder {

    @Autowired
    CommentServiceImpl commentService;

    @Autowired
    SongViewPageMapper viewPage;

    @Override
    protected SongMessageDAO songMessage() {
        return viewPage.selectMusicMessage(musicId);
    }

    @Override
    protected CommentPaginationInfoBO paginationInfo() {
        int elementCount = commentService.getElementCount(musicId, DEFAULT_TYPE);
        int paginationCount = commentService.getPaginationCount(elementCount);
        return new CommentPaginationInfoBO(elementCount,paginationCount);
    }

    @Override
    protected MusicCommentDAO[] songCommentDefaultElementList() {
        List<MusicCommentDAO> list = commentService.getPaginationService(DEFAULT_PAGE, musicId, DEFAULT_TYPE);
        MusicCommentDAO[] array = new MusicCommentDAO[list.size()];
        Util.listTransformArray(list, array);
        return array;
    }

}
