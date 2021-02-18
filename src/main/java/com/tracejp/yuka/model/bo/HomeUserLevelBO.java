package com.tracejp.yuka.model.bo;

import com.tracejp.yuka.model.dao.HomeUserLevelDAO;

/*********************************
 * @author traceJP
 *********************************/
public class HomeUserLevelBO {

    private Float loginDaysPercentage;
    private Float listenToSongPercentage;
    private HomeUserLevelDAO homeUserLevel;
    private Integer songCountByUser;

    public HomeUserLevelBO() {
    }

    public HomeUserLevelBO(Float loginDaysPercentage, Float listenToSongPercentage, HomeUserLevelDAO homeUserLevel, Integer songCountByUser) {
        this.loginDaysPercentage = loginDaysPercentage;
        this.listenToSongPercentage = listenToSongPercentage;
        this.homeUserLevel = homeUserLevel;
        this.songCountByUser = songCountByUser;
    }

    public Float getLoginDaysPercentage() {
        return loginDaysPercentage;
    }

    public void setLoginDaysPercentage(Float loginDaysPercentage) {
        this.loginDaysPercentage = loginDaysPercentage;
    }

    public Float getListenToSongPercentage() {
        return listenToSongPercentage;
    }

    public void setListenToSongPercentage(Float listenToSongPercentage) {
        this.listenToSongPercentage = listenToSongPercentage;
    }

    public HomeUserLevelDAO getHomeUserLevel() {
        return homeUserLevel;
    }

    public void setHomeUserLevel(HomeUserLevelDAO homeUserLevel) {
        this.homeUserLevel = homeUserLevel;
    }

    public Integer getSongCountByUser() {
        return songCountByUser;
    }

    public void setSongCountByUser(Integer songCountByUser) {
        this.songCountByUser = songCountByUser;
    }

    @Override
    public String toString() {
        return "HomeUserLevelBO{" +
                "loginDaysPercentage=" + loginDaysPercentage +
                ", listenToSongPercentage=" + listenToSongPercentage +
                ", homeUserLevelDAO=" + homeUserLevel +
                ", songCountByUser=" + songCountByUser +
                '}';
    }

}
