package com.tracejp.yuka.service.behavior.impl;

import com.tracejp.yuka.dao.BehaviorMapper;
import com.tracejp.yuka.model.enums.ResponseStatus;
import com.tracejp.yuka.service.behavior.UserBehaviorService;
import com.tracejp.yuka.service.level.UserLevelService;
import org.springframework.beans.factory.annotation.Autowired;

/*********************************
 * @author traceJP
 *********************************/
public class UserBehaviorServiceImpl implements UserBehaviorService {

    @Autowired
    UserLevelService userLevel;

    @Autowired
    BehaviorMapper behavior;


    @Override
    public String listenToSongRecord(Integer id, String uid) {
        // 用户听歌数量加一
        userLevel.addSongNumber(uid);
        // 记录听歌信息
        Integer number = behavior.selectUserMusicBroadcastNumber(id, uid);
        if(number == null) {
            number = 1;
        } else {
            number++;
        }
        behavior.insertUserMusicBroadcastNumber(id, number, uid);
        return ResponseStatus.SUCCESS_200.getStatus();
    }

    @Override
    public String listClickVolume(Integer id) {
        behavior.updateMusicListPlayCount(id);
        return ResponseStatus.SUCCESS_200.getStatus();
    }

}
