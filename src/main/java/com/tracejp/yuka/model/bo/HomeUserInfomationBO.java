package com.tracejp.yuka.model.bo;

/*********************************
 * @author traceJP
 *********************************/
public class HomeUserInfomationBO {

    private Integer userId;
    private String userAvatarImgUrl;
    private String userName;
    private String userArea;
    private String userSex;
    private Integer userAge;

    public HomeUserInfomationBO() {
    }

    public HomeUserInfomationBO(Integer userId, String userAvatarImgUrl, String userName, String userArea, String userSex, Integer userAge) {
        this.userId = userId;
        this.userAvatarImgUrl = userAvatarImgUrl;
        this.userName = userName;
        this.userArea = userArea;
        this.userSex = userSex;
        this.userAge = userAge;
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

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    @Override
    public String toString() {
        return "HomeUserInfomationBO{" +
                "userId=" + userId +
                ", userAvatarImgUrl='" + userAvatarImgUrl + '\'' +
                ", userName='" + userName + '\'' +
                ", userArea='" + userArea + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userAge=" + userAge +
                '}';
    }

}
