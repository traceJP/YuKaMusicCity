package com.tracejp.yuka.model.vo;

/*********************************
 * @author traceJP
 *********************************/
@Deprecated
public class CommentStatusVO {

    private Integer commentId;
    private Integer upvoteOppose;

    public CommentStatusVO() {
    }

    public CommentStatusVO(Integer commentId, Integer upvoteOppose) {
        this.commentId = commentId;
        this.upvoteOppose = upvoteOppose;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getUpvoteOppose() {
        return upvoteOppose;
    }

    public void setUpvoteOppose(Integer upvoteOppose) {
        this.upvoteOppose = upvoteOppose;
    }

    @Override
    public String toString() {
        return "CommentStatusVO{" +
                "commentId=" + commentId +
                ", upvoteOppose=" + upvoteOppose +
                '}';
    }

}
