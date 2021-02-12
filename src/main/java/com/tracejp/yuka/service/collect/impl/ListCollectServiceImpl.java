package com.tracejp.yuka.service.collect.impl;

import com.tracejp.yuka.dao.CollectMapper;
import com.tracejp.yuka.model.enums.ResponseStatus;
import com.tracejp.yuka.service.collect.ListCollectService;
import com.tracejp.yuka.utils.LocalFileCommandUtil;
import com.tracejp.yuka.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/*********************************
 * @author traceJP
 *********************************/
@Service
public class ListCollectServiceImpl implements ListCollectService {

    @Autowired
    private CollectMapper musicCollect;

    @Autowired
    private LocalFileCommandUtil.Builder fileSave;

    @Override
    public String addUserMusicList(String uid, String listName, MultipartFile fileImg) {
        String localUrl = null;
        try {
            LocalFileCommandUtil fileObj = fileSave.builderMultipartFile(fileImg)
                                                        .builderConfigKey("musicListImgUrl")
                                                        .builderFileName(Util.getRandomString(16))
                                                        .builder();
            localUrl = fileObj.saveFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(localUrl == null) {
            return ResponseStatus.SUCCESS_ERROR.getStatus();
        }
        musicCollect.insertUserMusicList(uid, listName, localUrl, false);
        return ResponseStatus.SUCCESS_200.getStatus();
    }

    @Override
    public String removeUserMusicList(String uid, Integer listId) {
        if(!isUserCreateMusicList(uid, listId)) {
            return ResponseStatus.SUCCESS_ERROR.getStatus();
        }
        // TODO: 2021/2/8 删除歌单需要删除清空对应歌曲表的记录
        //        记录包括/ 歌单表，歌单值表，歌单评论表，歌单评论记录表，歌单用户收藏表

        return ResponseStatus.SUCCESS_200.getStatus();
    }

    @Override
    public String addUserCollectMusicList(String uid, Integer listId) {
        if(isUserCollectMusicList(uid, listId)) {
            return ResponseStatus.SUCCESS_ERROR.getStatus();
        }
        musicCollect.insertCollectMusicList(uid, listId);
        return ResponseStatus.SUCCESS_200.getStatus();
    }

    @Override
    public String removeUserCollectMusicList(String uid, Integer listId) {
        if(!isUserCollectMusicList(uid, listId)) {
            return ResponseStatus.SUCCESS_ERROR.getStatus();
        }
        musicCollect.deleteCollectMusicList(listId);
        return ResponseStatus.SUCCESS_200.getStatus();
    }

    @Override
    public Boolean isUserCreateMusicList(String uid, Integer listId) {
        int ans = musicCollect.selectIsUserCreateMusicList(uid, listId);
        return ans == 1;
    }

    @Override
    public Boolean isUserCollectMusicList(String uid, Integer listId) {
        int ans = musicCollect.selectIsUserCollectMusicList(uid, listId);
        return ans == 1;
    }

}
