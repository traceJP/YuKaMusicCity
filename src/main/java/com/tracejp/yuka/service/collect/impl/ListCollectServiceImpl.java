package com.tracejp.yuka.service.collect.impl;

import com.tracejp.yuka.dao.CollectMapper;
import com.tracejp.yuka.model.enums.ResponseStatus;
import com.tracejp.yuka.service.collect.ListCollectService;
import com.tracejp.yuka.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

/*********************************
 * @author traceJP
 *********************************/
@Service
public class ListCollectServiceImpl implements ListCollectService {

    @Autowired
    CollectMapper musicCollect;

    @Override
    public String addUserMusicList(String uid, String listName, MultipartFile fileImg) {
        String localUrl = null;
        try {
            localUrl = saveFileImageToLocal(fileImg);
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
        //        记录包括/ 歌单表，歌单值表，歌单评论表，歌单用户收藏表

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

    /**
     * config资源路径
     */
    private final String configUrl = "properties/LocalFileUrlConfig.properties";

    /**
     * 保存图片文件到本地
     * @param fileImg MultipartFile
     * @return 返回保存的路径
     */
    private String saveFileImageToLocal(MultipartFile fileImg) throws IOException {
        Properties properties = PropertiesLoaderUtils.loadAllProperties(configUrl);
        String url = properties.getProperty("musicListImgUrl");
        // 路径为：config路径 + 16位随机生成数文件名 + 传入的文件类型
        StringBuilder builderLocalUrl = new StringBuilder();
        builderLocalUrl.append(url);
        // TODO： 分隔符可能出现问题
        builderLocalUrl.append(File.pathSeparator);
        builderLocalUrl.append(Util.getRandomString(16));
        builderLocalUrl.append(".");
        builderLocalUrl.append(fileImg.getContentType());
        // 新建并保存文件
        File newFile = new File(builderLocalUrl.toString());
        if(!newFile.createNewFile()) {
            return null;
        }
        fileImg.transferTo(newFile);
        return builderLocalUrl.toString();
    }

}
