package com.tracejp.yuka.model.bo;

/*********************************
 * @author traceJP
 *********************************/
public class HomeUserInfomationBO {

    private String userId;
    private String userAvatarImgUrl;
    private String userName;
    private String userArea;
    private String userSex;
    private Integer userAge;
    private String userIntroduction;

    public HomeUserInfomationBO() {
    }

    public HomeUserInfomationBO(String userId, String userAvatarImgUrl, String userName, String userArea, String userSex, Integer userAge, String userIntroduction) {
        this.userId = userId;
        this.userAvatarImgUrl = userAvatarImgUrl;
        this.userName = userName;
        this.userArea = userArea;
        this.userSex = userSex;
        this.userAge = userAge;
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

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserIntroduction() {
        return userIntroduction;
    }

    public void setUserIntroduction(String userIntroduction) {
        this.userIntroduction = userIntroduction;
    }

    @Override
    public String toString() {
        return "HomeUserInfomationBO{" +
                "userId='" + userId + '\'' +
                ", userAvatarImgUrl='" + userAvatarImgUrl + '\'' +
                ", userName='" + userName + '\'' +
                ", userArea='" + userArea + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userAge=" + userAge +
                ", userIntroduction='" + userIntroduction + '\'' +
                '}';
    }

}
