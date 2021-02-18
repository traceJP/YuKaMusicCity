package com.tracejp.yuka.model.dao;

import java.sql.Date;

/*********************************
 * @author traceJP
 *********************************/
public class HomeUserInformationDAO {

    private String userId;
    private String userAvatarImgUrl;
    private String userName;
    private String userArea;
    private String userSex;
    private Date userBirthday;
    private String userIntroduction;

    public HomeUserInformationDAO() {
    }

    public HomeUserInformationDAO(String userId, String userAvatarImgUrl, String userName, String userArea, String userSex, Date userBirthday, String userIntroduction) {
        this.userId = userId;
        this.userAvatarImgUrl = userAvatarImgUrl;
        this.userName = userName;
        this.userArea = userArea;
        this.userSex = userSex;
        this.userBirthday = userBirthday;
        this.userIntroduction = userIntroduction;
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

    public String getUserIntroduction() {
        return userIntroduction;
    }

    public void setUserIntroduction(String userIntroduction) {
        this.userIntroduction = userIntroduction;
    }

    @Override
    public String toString() {
        return "HomeUserInformationDAO{" +
                "userId='" + userId + '\'' +
                ", userAvatarImgUrl='" + userAvatarImgUrl + '\'' +
                ", userName='" + userName + '\'' +
                ", userArea='" + userArea + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userBirthday=" + userBirthday +
                ", userIntroduction='" + userIntroduction + '\'' +
                '}';
    }

}
