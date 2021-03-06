package com.tracejp.yuka.model.vo;

import com.tracejp.yuka.model.bo.HomeListenToSongsBO;
import com.tracejp.yuka.model.bo.HomeUserInfomationBO;
import com.tracejp.yuka.model.bo.HomeUserLevelBO;

import java.util.Arrays;

/*********************************
 * @author traceJP
 *********************************/
public class HomeVO {

    HomeUserInfomationBO userInfomation;
    HomeUserLevelBO userLevel;
    HomeListenToSongsBO[] songRank;

    public HomeVO() {
    }

    public HomeVO(HomeUserInfomationBO userInfomation, HomeUserLevelBO userLevel, HomeListenToSongsBO[] songRank) {
        this.userInfomation = userInfomation;
        this.userLevel = userLevel;
        this.songRank = songRank;
    }

    public HomeUserInfomationBO getUserInfomation() {
        return userInfomation;
    }

    public void setUserInfomation(HomeUserInfomationBO userInfomation) {
        this.userInfomation = userInfomation;
    }

    public HomeUserLevelBO getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(HomeUserLevelBO userLevel) {
        this.userLevel = userLevel;
    }

    public HomeListenToSongsBO[] getSongRank() {
        return songRank;
    }

    public void setSongRank(HomeListenToSongsBO[] songRank) {
        this.songRank = songRank;
    }

    @Override
    public String toString() {
        return "HomeVO{" +
                "userInfomation=" + userInfomation +
                ", userLevel=" + userLevel +
                ", songRank=" + Arrays.toString(songRank) +
                '}';
    }

}
