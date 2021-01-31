package com.tracejp.yuka.model.bo;

/*********************************
 * @author traceJP
 *********************************/
public class CommentPaginationInfoBO {

    private Integer commentCount;
    private Integer paginationCount;

    public CommentPaginationInfoBO() {
    }

    public CommentPaginationInfoBO(Integer commentCount, Integer paginationCount) {
        this.commentCount = commentCount;
        this.paginationCount = paginationCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getPaginationCount() {
        return paginationCount;
    }

    public void setPaginationCount(Integer paginationCount) {
        this.paginationCount = paginationCount;
    }

    @Override
    public String toString() {
        return "CommentPaginationInfoBO{" +
                "commentCount=" + commentCount +
                ", paginationCount=" + paginationCount +
                '}';
    }

}
