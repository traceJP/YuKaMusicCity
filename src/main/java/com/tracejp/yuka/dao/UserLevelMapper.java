package com.tracejp.yuka.dao;

/*********************************
 * @author traceJP
 *********************************/
public interface UserLevelMapper {

    /**
     * 根据uid将对应的user_level表中的登录天数+1
     * @param uid uid
     */
    void updateLoginDaysPlusOne(String uid);

    /**
     * 根据uid将对应的user_level表中的听歌数+1
     * @param uid uid
     */
    void updateSongNumberPlusOne(String uid);

    /**
     * 用户升级
     * @param uid uid
     */
    void updateUserLevelNumber(String uid);

}
