package com.tracejp.yuka.model.vo;

import com.tracejp.yuka.model.bo.CommentPaginationInfoBO;
import com.tracejp.yuka.model.dao.MusicCommentDAO;
import com.tracejp.yuka.model.dao.PlaylistMessageDAO;
import com.tracejp.yuka.model.dao.PlaylistMusicListElementDAO;

import java.util.Arrays;

/*********************************
 * @author traceJP
 *********************************/
public class PlaylistVO {

    private PlaylistMessageDAO message;
    private PlaylistMusicListElementDAO[] musicList;
    private Integer musicCount;
    private MusicCommentDAO[] comment;
    private CommentPaginationInfoBO paginationInfo;

    public PlaylistVO() {
    }

    public PlaylistVO(PlaylistMessageDAO message, PlaylistMusicListElementDAO[] musicList, Integer musicCount, MusicCommentDAO[] comment, CommentPaginationInfoBO paginationInfo) {
        this.message = message;
        this.musicList = musicList;
        this.musicCount = musicCount;
        this.comment = comment;
        this.paginationInfo = paginationInfo;
    }

    public PlaylistMessageDAO getMessage() {
        return message;
    }

    public void setMessage(PlaylistMessageDAO message) {
        this.message = message;
    }

    public PlaylistMusicListElementDAO[] getMusicList() {
        return musicList;
    }

    public void setMusicList(PlaylistMusicListElementDAO[] musicList) {
        this.musicList = musicList;
    }

    public Integer getMusicCount() {
        return musicCount;
    }

    public void setMusicCount(Integer musicCount) {
        this.musicCount = musicCount;
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
        return "PlaylistVO{" +
                "message=" + message +
                ", musicList=" + Arrays.toString(musicList) +
                ", musicCount=" + musicCount +
                ", comment=" + Arrays.toString(comment) +
                ", paginationInfo=" + paginationInfo +
                '}';
    }

}
