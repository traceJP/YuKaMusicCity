package com.tracejp.yuka.service.collect;

import com.tracejp.yuka.model.vo.MusicCollectVO;

/*********************************
 * @author traceJP
 *********************************/
public interface MusicCollectService {

    /**
     * 添加歌曲收藏到对应的歌单中
     * @param musicId 歌曲id
     * @param listId 歌单id
     * @param uid 用户id
     * @return 取消成功返回200， 否则返回返回404
     */
    String addCollect(Integer musicId, Integer listId, String uid);

    /**
     * 取消对应歌单的歌曲收藏
     * @param musicId 歌曲id
     * @param listId 歌单id
     * @param uid 用户id
     * @return 取消成功返回200， 否则返回返回404
     */
    String cancelCollect(Integer musicId, Integer listId, String uid);

    /**
     * 根据用户查找并返回对应的自己创建的歌单
     * @param musicId 歌曲id
     * @param uid 用户id
     * @return 总视图
     */
    MusicCollectVO[] musicCollectSelectList(Integer musicId, String uid);

    /**
     * 在歌单集合中标识是否有对应的musicId
     * @param musicId 歌曲id
     * @param listId 集合id
     * @return
     */
    Boolean listHasMusicId(Integer musicId, Integer listId);

}
