package com.tracejp.yuka.service.collect.impl;

import com.tracejp.yuka.dao.MusicCollectMapper;
import com.tracejp.yuka.model.enums.ResponseStatus;
import com.tracejp.yuka.model.vo.MusicCollectVO;
import com.tracejp.yuka.service.collect.MusicCollectService;
import com.tracejp.yuka.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*********************************
 * @author traceJP
 *********************************/
@Service
public class MusicCollectServiceImpl implements MusicCollectService {

    @Autowired
    MusicCollectMapper musicCollect;

    @Override
    public String addCollect(Integer musicId, Integer listId, String uid) {
        if(!isListFromUid(listId, uid)) {
            return ResponseStatus.SUCCESS_ERROR.getStatus();
        }
        musicCollect.insertMusicCollect(musicId, listId);
        return ResponseStatus.SUCCESS_200.getStatus();
    }

    @Override
    public String cancelCollect(Integer musicId, Integer listId, String uid) {
        if(!isListFromUid(listId, uid)) {
            return ResponseStatus.SUCCESS_ERROR.getStatus();
        }
        musicCollect.deleteMusicCollect(musicId, listId);
        return ResponseStatus.SUCCESS_200.getStatus();
    }

    @Override
    public MusicCollectVO[] musicCollectSelectList(Integer musicId, String uid) {
        List<MusicCollectVO> list = musicCollect.selectUserMusicList(uid);
        MusicCollectVO[] array = new MusicCollectVO[list.size()];
        Util.listTransformArray(list, array);
        for (MusicCollectVO item : array) {
            boolean hasMusic = listHasMusicId(musicId, item.getId());
            item.setHasMusic(hasMusic);
        }
        return array;
    }

    @Override
    public Boolean listHasMusicId(Integer musicId, Integer listId) {
        int ans = musicCollect.selectListHasMusicId(musicId, listId);
        return ans == 1;
    }

    /**
     * 验证保护机制：查询传入的listId是否属于当前用户
     * @param listId 歌单id
     * @param uid 用户id
     * @return 属于返回true，不属于返回false
     */
    boolean isListFromUid(Integer listId, String uid) {
        int ans = musicCollect.selectIsListFromUid(listId, uid);
        return ans == 1;
    }


}
