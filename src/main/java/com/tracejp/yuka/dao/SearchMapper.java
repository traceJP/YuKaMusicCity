package com.tracejp.yuka.dao;

import com.tracejp.yuka.model.vo.SearchVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*********************************
 * @author traceJP
 *********************************/
public interface SearchMapper {

    /**
     * 默认搜索策略
     * @param word
     * @param resultCount
     * @return
     */
    List<SearchVO> selectDefaultSearch(@Param("word") String word, @Param("resultCount") Integer resultCount);

    /**
     * 只搜索音乐策略
     * @param word
     * @param resultCount
     * @return
     */
    List<SearchVO> selectMusicSearch(@Param("word") String word, @Param("resultCount") Integer resultCount);

    /**
     * 只搜索歌单策略
     * @param word
     * @param resultCount
     * @return
     */
    List<SearchVO> selectListSearch(@Param("word") String word, @Param("resultCount") Integer resultCount);

    /**
     * 只通过作者搜索策略
     * @param word
     * @param resultCount
     * @return
     */
    List<SearchVO> selectAuthorSearch(@Param("word") String word, @Param("resultCount") Integer resultCount);

}
