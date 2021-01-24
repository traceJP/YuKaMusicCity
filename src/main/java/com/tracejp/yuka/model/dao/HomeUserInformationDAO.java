package com.tracejp.yuka.model.dao;

import java.sql.Date;

/*********************************
 * @author traceJP
 *********************************/
public class HomeUserInformationDAO {

    private Integer userId;
    private String userAvatarImgUrl;
    private String userName;
    private String userArea;
    private String userSex;
    private Date userBirthday;

    public HomeUserInformationDAO() {
    }

    public HomeUserInformationDAO(Integer userId, String userAvatarImgUrl, String userName, String userArea, String userSex, Date userBirthday) {
        this.userId = userId;
        this.userAvatarImgUrl = userAvatarImgUrl;
        this.userName = userName;
        this.userArea = userArea;
        this.userSex = userSex;
        this.userBirthday = userBirthday;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
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

    public String getUserArea() {
        return userArea;
    }

    public void setUserArea(String userArea) {
        this.userArea = userArea;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    @Override
    public String toString() {
        return "HomeUserInformationDAO{" +
                "userId='" + userId + '\'' +
                ", userAvatarImgUrl='" + userAvatarImgUrl + '\'' +
                ", userName='" + userName + '\'' +
                ", userArea='" + userArea + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userBirthday='" + userBirthday + '\'' +
                '}';
    }

}
