package com.tracejp.yuka.service.comment.impl;

import com.tracejp.yuka.dao.CommentMapper;
import com.tracejp.yuka.model.dao.MusicCommentDAO;
import com.tracejp.yuka.model.enums.ResponseStatus;
import com.tracejp.yuka.model.vo.CommentStatusVO;
import com.tracejp.yuka.service.comment.CommentService;
import com.tracejp.yuka.service.comment.PaginationModelService;
import com.tracejp.yuka.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*********************************
 * @author traceJP
 *********************************/
@Service
public class CommentServiceImpl
        implements PaginationModelService<MusicCommentDAO>, CommentService {

    /**
     * 前端一页展示的数量
     */
    public static Integer elementReturnCount = 6;

    @Autowired
    CommentMapper commentDAO;

    @Override
    public MusicCommentDAO[] getPaginationService(Integer pageNumber, Integer id, Integer type) {
        // 传入pageNumber参数不可以大于总页数
        int elementCount = getElementCount(id, type);
        if(pageNumber > elementCount) {
            return null;
        }
        int pageBegin = getElementBegin(pageNumber);
        List<MusicCommentDAO> list = commentDAO.selectCommentElement(id, type, pageBegin, elementReturnCount);
        MusicCommentDAO[] array = new MusicCommentDAO[list.size()];
        Util.listTransformArray(list, array);
        return array;
    }

    @Override
    public Integer getElementCount(Integer id, Integer type) {
        return commentDAO.selectCommentCount(id, type);
    }

    @Override
    public Integer getPaginationCount(Integer elementCount) {
        int ans = elementCount / elementReturnCount;
        if(elementCount % elementReturnCount > 0) {
            ans++;
        }
        return ans;
    }

    @Override
    public Integer getElementBegin(Integer pageNo) {
        return (pageNo - 1) * elementReturnCount;
    }


    @Override
    public String addCommentText(Integer id, Integer type, String text, String uid) {
        if(text.length() > COMMENT_TEXT_LENGTH || text.length() == 0) {
            return ResponseStatus.SUCCESS_ERROR.getStatus();
        }
        commentDAO.insertCommentText(id, type, text, uid);
        return ResponseStatus.SUCCESS_200.getStatus();
    }

    @Override
    public Integer[] initUserCommentData(Integer[] commentList, String uid) {
        int length = commentList.length;
        if(length == 0) {
            return null;
        }
        Integer[] res = new Integer[length];
        for(int i = 0; i < length; i++) {
            res[i] = commentList[i];
            res[i] = commentDAO.selectCommentStatus(commentList[i], uid);
        }
        return res;
    }

    @Override
    public String userUpvoteComment(Integer id, String uid) {
        Integer status = commentDAO.selectCommentStatus(id, uid);
        userCommentUpvoteOpposeNumber(status, UPVOTE_COMMENT_STATUS, id);
        commentDAO.replaceCommentStatus(id, UPVOTE_COMMENT_STATUS, uid);
        return ResponseStatus.SUCCESS_200.getStatus();
    }

    @Override
    public String userCancelUpvoteComment(Integer id, String uid) {
        commentDAO.deleteCommentKeep(id, uid);
        commentDAO.updateAddCommentUpvoteNumber(id, -1);
        return ResponseStatus.SUCCESS_200.getStatus();
    }

    @Override
    public String userOpposeComment(Integer id, String uid) {
        Integer status = commentDAO.selectCommentStatus(id, uid);
        userCommentUpvoteOpposeNumber(status, OPPOSE_COMMENT_STATUS, id);
        commentDAO.replaceCommentStatus(id, OPPOSE_COMMENT_STATUS, uid);
        return ResponseStatus.SUCCESS_200.getStatus();
    }

    @Override
    public String userCancelOpposeComment(Integer id, String uid) {
        commentDAO.deleteCommentKeep(id, uid);
        commentDAO.updateAddCommentOpposeNumber(id, -1);
        return ResponseStatus.SUCCESS_200.getStatus();
    }

    /**
     * 根据当前状态和即将修改的状态增删UpvoteOppose_number
     * @param status 当前状态
     * @param modify 即将更改的状态：1为点赞 2为点踩
     */
    private void userCommentUpvoteOpposeNumber(Integer status, Integer modify, Integer id) {
        // 无任何原始状态
        if(status == null) {
            if(modify == UPVOTE_COMMENT_STATUS) {
                commentDAO.updateAddCommentUpvoteNumber(id, 1);
            }
            if(modify == OPPOSE_COMMENT_STATUS) {
                commentDAO.updateAddCommentOpposeNumber(id, 1);
            }
            return;
        }
        // 点赞到点踩的转化
        if(status == UPVOTE_COMMENT_STATUS && modify == OPPOSE_COMMENT_STATUS) {
            commentDAO.updateAddCommentUpvoteNumber(id, -1);
            commentDAO.updateAddCommentOpposeNumber(id, 1);
        }
        // 点踩到点赞的转化
        if(status == OPPOSE_COMMENT_STATUS && modify == UPVOTE_COMMENT_STATUS) {
            commentDAO.updateAddCommentUpvoteNumber(id, 1);
            commentDAO.updateAddCommentOpposeNumber(id, -1);
        }
    }

}
