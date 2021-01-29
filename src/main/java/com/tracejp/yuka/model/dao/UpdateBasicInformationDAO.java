package com.tracejp.yuka.model.dao;

import java.sql.Date;

/*********************************
 * @author traceJP
 *********************************/
public class UpdateBasicInformationDAO {

    private String userName;
    private String userSex;
    private Date userBirthday;
    private String userAvatarImgUrl;
    private String userIntroduction;
    private String userArea;

    public UpdateBasicInformationDAO() {
    }

    public UpdateBasicInformationDAO(String userName, String userSex, Date userBirthday, String userAvatarImgUrl, String userIntroduction, String userArea) {
        this.userName = userName;
        this.userSex = userSex;
        this.userBirthday = userBirthday;
        this.userAvatarImgUrl = userAvatarImgUrl;
        this.userIntroduction = userIntroduction;
        this.userArea = userArea;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getUserAvatarImgUrl() {
        return userAvatarImgUrl;
    }

    public void setUserAvatarImgUrl(String userAvatarImgUrl) {
        this.userAvatarImgUrl = userAvatarImgUrl;
    }

    public String getUserIntroduction() {
        return userIntroduction;
    }

    public void setUserIntroduction(String userIntroduction) {
        this.userIntroduction = userIntroduction;
    }

    public String getUserArea() {
        return userArea;
    }

    public void setUserArea(String userArea) {
        this.userArea = userArea;
    }

    @Override
    public String toString() {
        return "UpdateBasicInformationDAO{" +
                "userName='" + userName + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userBirthday=" + userBirthday +
                ", userAvatarImgUrl='" + userAvatarImgUrl + '\'' +
                ", userIntroduction='" + userIntroduction + '\'' +
                ", userArea='" + userArea + '\'' +
                '}';
    }

}
