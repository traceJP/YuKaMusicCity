package com.tracejp.yuka.dao;

import com.tracejp.yuka.model.dao.HomeListenToSongsDAO;
import com.tracejp.yuka.model.dao.HomeUserInformationDAO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*********************************
 * @author traceJP
 *********************************/
public interface HomeViewPageMapper {

    /**
     * 通过uid查询相应的用户信息
     * @param uid uid
     * @return HomeUserInformationDAO
     */
    HomeUserInformationDAO selectUserInfo(@Param("uid") String uid);

    /**
     * 通过uid获取以单个歌曲自己听歌数量为升序的歌曲信息
     * @param uid uid
     * @param resultCount 限制返回记录数量
     * @return HomeListenToSongsDAO
     */
    List<HomeListenToSongsDAO> selectUserSongsRank(@Param("uid") String uid, @Param("resultCount") String resultCount);


}
