package com.tracejp.yuka.model.bo;

import com.tracejp.yuka.model.dao.HomeUserLevelDAO;

/*********************************
 * @author traceJP
 * 此BO中有DAO，完善传回业务，构造需要传入HomeUserLevelDAO对象，或使用set注入
 *********************************/
public class HomeUserLevelBO {

    // 登录天数进度条百分比-用精度表示

    private Float loginDaysPercentage;
    private Float listenToSongPercentage;
    private HomeUserLevelDAO homeUserLevelDAO;

    public HomeUserLevelBO() {
    }

    public HomeUserLevelBO(Float loginDaysPercentage, Float listenToSongPercentage, HomeUserLevelDAO homeUserLevelDAO) {
        this.loginDaysPercentage = loginDaysPercentage;
        this.listenToSongPercentage = listenToSongPercentage;
        this.homeUserLevelDAO = homeUserLevelDAO;
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

    @Override
    public String toString() {
        return "HomeUserLevelBO{" +
                "loginDaysPercentage=" + loginDaysPercentage +
                ", listenToSongPercentage=" + listenToSongPercentage +
                ", homeUserLevelDAO=" + homeUserLevelDAO +
                '}';
    }

}
