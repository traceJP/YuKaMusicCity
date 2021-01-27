package com.tracejp.yuka.service;

/*********************************
 * @author traceJP
 * 用户等级模块接口
 *********************************/
public interface UserLevelService {

    /**
     * 增加登录天数
     * @param uid uid
     */
    void addLoginDays(String uid);

    /**
     * 增加听歌数量
     * @param uid uid
     */
    void addSongNumber(String uid);

    /**
     * 根据等级和当前登录天数转化为剩余登录天数
     * @param level 等级
     * @param loginNumber 登录天数
     * @return 剩余登录天数
     */
    int overLoginConverter(int level, int loginNumber);

    /**
     * 根据等级和当前听歌数转化为剩余听歌数
     * @param level 等级
     * @param songNumber 听歌数
     * @return 剩余听歌数
     */
    int overSongNumberConverter(int level, int songNumber);

    /**
     * 根据等级和当前登录数转为为剩余登录数的百分比
     * @param level 等级
     * @param loginNumber 登录数
     * @return 百分比剩余登录数
     */
    float percentageLoginConverter(int level, int loginNumber);

    /**
     * 根据等级和当前听歌数转为为剩余听歌数的百分比
     * @param level 等级
     * @param songNumber 听歌数
     * @return 百分比剩余听歌数
     */
    float percentageSongNumberConverter(int level, int songNumber);

}
