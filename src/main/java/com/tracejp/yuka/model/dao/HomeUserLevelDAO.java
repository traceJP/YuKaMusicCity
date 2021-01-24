package com.tracejp.yuka.model.dao;

/*********************************
 * @author traceJP
 *********************************/
public class HomeUserLevelDAO {

    private Integer levelNumber;
    private Integer userLoginDays;
    private Integer userSongNumber;

    public HomeUserLevelDAO() {
    }

    public HomeUserLevelDAO(Integer levelNumber, Integer userLoginDays, Integer userSongNumber) {
        this.levelNumber = levelNumber;
        this.userLoginDays = userLoginDays;
        this.userSongNumber = userSongNumber;
    }

    public Integer getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(Integer levelNumber) {
        this.levelNumber = levelNumber;
    }

    public Integer getUserLoginDays() {
        return userLoginDays;
    }

    public void setUserLoginDays(Integer userLoginDays) {
        this.userLoginDays = userLoginDays;
    }

    public Integer getUserSongNumber() {
        return userSongNumber;
    }

    public void setUserSongNumber(Integer userSongNumber) {
        this.userSongNumber = userSongNumber;
    }

    @Override
    public String toString() {
        return "HomeUserLevelDAO{" +
                "levelNumber=" + levelNumber +
                ", userLoginDays=" + userLoginDays +
                ", userSongNumber=" + userSongNumber +
                '}';
    }

}
