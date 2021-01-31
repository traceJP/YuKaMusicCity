package com.tracejp.yuka.model.vo;

import com.tracejp.yuka.model.bo.CommentPaginationInfoBO;
import com.tracejp.yuka.model.dao.MusicCommentDAO;
import com.tracejp.yuka.model.dao.SongMessageDAO;

/*********************************
 * @author traceJP
 *********************************/
public class SongVO {

    private SongMessageDAO songMessage;
    private MusicCommentDAO[] comment;
    private CommentPaginationInfoBO paginationInfo;

    public SongVO() {
    }

    public SongVO(SongMessageDAO songMessage, MusicCommentDAO[] comment, CommentPaginationInfoBO paginationInfo) {
        this.songMessage = songMessage;
        this.comment = comment;
        this.paginationInfo = paginationInfo;
    }

    public SongMessageDAO getSongMessage() {
        return songMessage;
    }

    public void setSongMessage(SongMessageDAO songMessage) {
        this.songMessage = songMessage;
    }

    public MusicCommentDAO[] getComment() {
        return comment;
    }

    public void setComment(MusicCommentDAO[] comment) {
        this.comment = comment;
    }

    public CommentPaginationInfoBO getPaginationInfo() {
        return paginationInfo;
    }

    public void setPaginationInfo(CommentPaginationInfoBO paginationInfo) {
        this.paginationInfo = paginationInfo;
    }

    @Override
    public String toString() {
        return "SongVO{" +
                "songMessage=" + songMessage +
                ", comment=" + comment +
                ", paginationInfo=" + paginationInfo +
                '}';
    }

}
