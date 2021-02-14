package com.tracejp.yuka.controller;

import com.tracejp.yuka.model.dao.MusicCommentDAO;
import com.tracejp.yuka.model.vo.CommentStatusVO;
import com.tracejp.yuka.service.comment.impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*********************************
 * @author traceJP
 *********************************/
@RestController
public class CommentController {

    @Autowired
    CommentServiceImpl commentService;

    @GetMapping("/getPagination")
    public MusicCommentDAO[] getCommentPaginationData(Integer pageNumber, Integer id, Integer type) {
        return commentService.getPaginationService(pageNumber, id, type);
    }

    @PostMapping("/user/addComment")
    public String addCommentText(Integer id, Integer type, String text, @SessionAttribute String uid) {
        return commentService.addCommentText(id, type, text, uid);
    }

    @GetMapping("/user/initUserComment")
    public CommentStatusVO[] initUserCommentData(Integer[] commentList, @SessionAttribute String uid) {
        return commentService.initUserCommentData(commentList, uid);
    }

    @PostMapping("/user/upvoteComment/{id}")
    String userUpvoteComment(@PathVariable("id") Integer id, @SessionAttribute String uid) {
        return commentService.userUpvoteComment(id, uid);
    }

    @DeleteMapping("/user/upvoteCancel/{id}")
    String userCancelUpvoteComment(@PathVariable("id") Integer id, @SessionAttribute String uid) {
        return commentService.userCancelUpvoteComment(id, uid);
    }

    @PostMapping("/user/opposeComment/{id}")
    String userOpposeComment(@PathVariable("id") Integer id, @SessionAttribute String uid) {
        return commentService.userCancelOpposeComment(id, uid);
    }

    @DeleteMapping("/user/opposeCancel/{id}")
    String userCancelOpposeComment(@PathVariable("id") Integer id, @SessionAttribute String uid) {
        return commentService.userCancelOpposeComment(id, uid);
    }

}
