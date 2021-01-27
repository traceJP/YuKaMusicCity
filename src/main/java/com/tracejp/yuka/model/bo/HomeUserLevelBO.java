package com.tracejp.yuka.model.bo;

import com.tracejp.yuka.model.dao.HomeUserLevelDAO;

/*********************************
 * @author traceJP
 *********************************/
public class HomeUserLevelBO {

    private Float loginDaysPercentage;
    private Float listenToSongPercentage;
    private HomeUserLevelDAO homeUserLevelDAO;
    private Integer songCountByUser;

    public HomeUserLevelBO() {
    }

    public HomeUserLevelBO(Float loginDaysPercentage, Float listenToSongPercentage, HomeUserLevelDAO homeUserLevelDAO, Integer songCountByUser) {
        this.loginDaysPercentage = loginDaysPercentage;
        this.listenToSongPercentage = listenToSongPercentage;
        this.homeUserLevelDAO = homeUserLevelDAO;
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

    public HomeUserLevelDAO getHomeUserLevelDAO() {
        return homeUserLevelDAO;
    }

    public void setHomeUserLevelDAO(HomeUserLevelDAO homeUserLevelDAO) {
        this.homeUserLevelDAO = homeUserLevelDAO;
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
                ", homeUserLevelDAO=" + homeUserLevelDAO +
                ", songCountByUser=" + songCountByUser +
                '}';
    }

}
