package com.tracejp.yuka.model.dao;

import java.sql.Date;

/*********************************
 * @author traceJP
 *********************************/
public class PlaylistMessageDAO {

    private Integer id;
    private String musicListName;
    private String musicListImgUrl;
    private Date musicListDatetime;
    private String userName;
    private String userAvatarImgUrl;

    public PlaylistMessageDAO() {
    }

    public PlaylistMessageDAO(Integer id, String musicListName, String musicListImgUrl, Date musicListDatetime, String userName, String userAvatarImgUrl) {
        this.id = id;
        this.musicListName = musicListName;
        this.musicListImgUrl = musicListImgUrl;
        this.musicListDatetime = musicListDatetime;
        this.userName = userName;
        this.userAvatarImgUrl = userAvatarImgUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMusicListName() {
        return musicListName;
    }

    public void setMusicListName(String musicListName) {
        this.musicListName = musicListName;
    }

    public String getMusicListImgUrl() {
        return musicListImgUrl;
    }

    public void setMusicListImgUrl(String musicListImgUrl) {
        this.musicListImgUrl = musicListImgUrl;
    }

    public Date getMusicListDatetime() {
        return musicListDatetime;
    }

    public void setMusicListDatetime(Date musicListDatetime) {
        this.musicListDatetime = musicListDatetime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAvatarImgUrl() {
        return userAvatarImgUrl;
    }

    public void setUserAvatarImgUrl(String userAvatarImgUrl) {
        this.userAvatarImgUrl = userAvatarImgUrl;
    }

    @Override
    public String toString() {
        return "PlaylistMessageDAO{" +
                "id=" + id +
                ", musicListName='" + musicListName + '\'' +
                ", musicListImgUrl='" + musicListImgUrl + '\'' +
                ", musicListDatetime=" + musicListDatetime +
                ", userName='" + userName + '\'' +
                ", userAvatarImgUrl='" + userAvatarImgUrl + '\'' +
                '}';
    }

}
