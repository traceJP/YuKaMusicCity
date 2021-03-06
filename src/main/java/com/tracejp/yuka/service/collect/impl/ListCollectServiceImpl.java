package com.tracejp.yuka.service.collect.impl;

import com.tracejp.yuka.dao.CollectMapper;
import com.tracejp.yuka.model.dao.CreateListParamsDAO;
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
    public String addUserMusicList(String uid, String listName, String listType, MultipartFile fileImg) {
        if(fileImg == null) {
            return ResponseStatus.SUCCESS_ERROR.getStatus();
        }
        String localUrl = null;
        try {
            LocalFileCommandUtil fileObj = fileSave.builderMultipartFile(fileImg)
                                                        .builderConfigKey("musicListImgUrl")
                                                        .builderFileName(Util.getRandomString(16))
                                                        .builder();
            fileObj.saveFile();
            localUrl = fileObj.getFileRelativelyUrl();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(localUrl == null) {
            return ResponseStatus.SUCCESS_ERROR.getStatus();
        }
        CreateListParamsDAO createListParams = new CreateListParamsDAO(
                null, uid, listName, listType, localUrl, false
        );
        musicCollect.insertUserMusicList(createListParams);
        return createListParams.getId().toString();
    }

    @Override
    public String removeUserMusicList(String uid, Integer listId) {
        if(!isUserCreateMusicList(uid, listId)) {
            return ResponseStatus.SUCCESS_ERROR.getStatus();
        }
        // TODO: 2021/2/25 删除歌单图片本地文件
        // 清除歌单表
        musicCollect.deleteUserMusicList(listId);
        // 清除歌单值表
        musicCollect.deleteUserMusicListValue(listId);
        // 清除用户收藏表
        musicCollect.deleteUserKeepMusicList(listId);
        // 清除歌单评论记录表
        musicCollect.deleteUserKeepComment(listId);
        // 清除歌单评论表
        musicCollect.deleteMusicListComment(listId);
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
