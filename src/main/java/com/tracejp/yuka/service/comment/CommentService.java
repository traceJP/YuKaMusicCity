package com.tracejp.yuka.service.comment;

import com.tracejp.yuka.model.vo.CommentStatusVO;

/*********************************
 * @author traceJP
 * 评论逻辑
 *********************************/
public interface CommentService {

    /**
     * 评论文本长度
     */
    int COMMENT_TEXT_LENGTH = 140;

    /**
     * 用户点赞评论状态
     */
    int UPVOTE_COMMENT_STATUS = 1;
    /**
     * 用户反对评论状态
     */
    int OPPOSE_COMMENT_STATUS = 2;


    /**
     * 评论新增
     * @param id id
     * @param type 1为歌曲 2为歌单
     * @param text 评论文本
     * @param uid uid
     * @return
     */
    String addCommentText(Integer id, Integer type, String text, String uid);

    /**
     * 初始化页面时，需要显示用户的操作记录
     * @param commentList 评论唯一标识集合
     * @param uid uid
     * @return
     */
    Integer[] initUserCommentData(Integer[] commentList, String uid);

    /**
     * 点赞评论
     * @param id 评论唯一标识
     * @param uid uid
     * @return
     */
    String userUpvoteComment(Integer id, String uid);

    /**
     * 取消点赞评论
     * @param id 评论唯一标识
     * @param uid uid
     * @return
     */
    String userCancelUpvoteComment(Integer id, String uid);

    /**
     * 点踩评论
     * @param id 评论唯一标识
     * @param uid uid
     * @return
     */
    String userOpposeComment(Integer id, String uid);

    /**
     * 取消点踩评论
     * @param id 评论唯一标识
     * @param uid uid
     * @return
     */
    String userCancelOpposeComment(Integer id, String uid);

}
