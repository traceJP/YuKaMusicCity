package com.tracejp.yuka.service.level.impl;

import com.tracejp.yuka.dao.UserLevelMapper;
import com.tracejp.yuka.service.level.UserLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Properties;

/*********************************
 * @author traceJP
 *********************************/
@Service
public class UserLevelServiceImpl implements UserLevelService {

    /**
     * readProperties方法声明参数
     */
    private final String LEVEL_MARK = "Lv";
    private final String DELIMITER_MARK = ".";
    private final String LOGIN_METHOD = "Login";
    private final String SONG_METHOD = "Song";
    private final String configURI = "properties/UserLevelConfig.properties";

    @Autowired
    private UserLevelMapper levelDao;

    @Override
    public void addLoginDays(String uid) {
        levelDao.updateLoginDaysPlusOne(uid);
    }

    @Override
    public void addSongNumber(String uid) {
        levelDao.updateSongNumberPlusOne(uid);
    }

    @Override
    public int overLoginConverter(int level, int loginNumber) {
        int total = readProperties(level, LOGIN_METHOD);
        return total - loginNumber;
    }

    @Override
    public int overSongNumberConverter(int level, int songNumber) {
        int total = readProperties(level, SONG_METHOD);
        return total - songNumber;
    }

    @Override
    public float percentageLoginConverter(int level, int loginNumber) {
        float total = readProperties(level, LOGIN_METHOD) - readProperties(level - 1, LOGIN_METHOD);
        return (float)loginNumber / total;
    }

    @Override
    public float percentageSongNumberConverter(int level, int songNumber) {
        float total = readProperties(level, SONG_METHOD) - readProperties(level - 1, SONG_METHOD);
        return (float)songNumber / total;
    }

    /**
     * 读取UserLevelConfig.properties配置文件
     * 根据等级和模式返回对应的值
     * @param level 等级（1-10）
     * @param method 模式 LOGIN_METHOD;SONG_METHOD;
     * @return properties值
     */
    private int readProperties(int level, String method) {
        String propertyObj = LEVEL_MARK + level + DELIMITER_MARK + method;
        Properties properties = null;
        try {
            properties = PropertiesLoaderUtils.loadAllProperties(configURI);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String propertyStr = properties.getProperty(propertyObj);
        return Integer.parseInt(propertyStr);
    }

}
