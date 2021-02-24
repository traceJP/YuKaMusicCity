package com.tracejp.yuka.service.behavior;

/*********************************
 * @author traceJP
 *********************************/
public interface UserBehaviorService {

    /**
     * 用户听歌历史记录
     * @param id 歌曲id
     * @param uid 用户id
     * @return 记录成功返回200
     */
    String listenToSongRecord(Integer id, String uid);

    /**
     * 歌单点击量记录
     * @param id
     * @return
     */
    String listClickVolume(Integer id);

}
