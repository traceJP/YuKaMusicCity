package com.tracejp.yuka.model.dao;

import java.sql.Date;

/*********************************
 * @author traceJP
 *********************************/
public class MusicCommentDAO {

    String userId;
    String userAvatarImgUrl;
    String userName;
    String commentText;
    Date commentDatetime;
    Integer commentAwesome;
    Integer commentOppose;

    public MusicCommentDAO() {
    }

    public MusicCommentDAO(String userId, String userAvatarImgUrl, String userName, String commentText, Date commentDatetime, Integer commentAwesome, Integer commentOppose) {
        this.userId = userId;
        this.userAvatarImgUrl = userAvatarImgUrl;
        this.userName = userName;
        this.commentText = commentText;
        this.commentDatetime = commentDatetime;
        this.commentAwesome = commentAwesome;
        this.commentOppose = commentOppose;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserAvatarImgUrl() {
        return userAvatarImgUrl;
    }

    public void setUserAvatarImgUrl(String userAvatarImgUrl) {
        this.userAvatarImgUrl = userAvatarImgUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Date getCommentDatetime() {
        return commentDatetime;
    }

    public void setCommentDatetime(Date commentDatetime) {
        this.commentDatetime = commentDatetime;
    }

    public Integer getCommentAwesome() {
        return commentAwesome;
    }

    public void setCommentAwesome(Integer commentAwesome) {
        this.commentAwesome = commentAwesome;
    }

    public Integer getCommentOppose() {
        return commentOppose;
    }

    public void setCommentOppose(Integer commentOppose) {
        this.commentOppose = commentOppose;
    }

    @Override
    public String toString() {
        return "MusicCommentDAO{" +
                "userId='" + userId + '\'' +
                ", userAvatarImgUrl='" + userAvatarImgUrl + '\'' +
                ", userName='" + userName + '\'' +
                ", commentText='" + commentText + '\'' +
                ", commentDatetime=" + commentDatetime +
                ", commentAwesome=" + commentAwesome +
                ", commentOppose=" + commentOppose +
                '}';
    }

}
