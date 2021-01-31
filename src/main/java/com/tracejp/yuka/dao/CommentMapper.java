package com.tracejp.yuka.dao;

import com.tracejp.yuka.model.dao.MusicCommentDAO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*********************************
 * @author traceJP
 *********************************/
public interface CommentMapper {

    /**
     * 通过type和id定位歌曲/歌单，并返回该元素的总的记录数
     * @param id id
     * @param type type
     * @return 记录总数
     */
    Integer selectCommentCount(@Param("id") Integer id, @Param("type") Integer type);

    /**
     * 通过type，id以及区间查询并返回指定的记录集合
     * @param id id
     * @param type type
     * @param begin 记录开始数
     * @param resultCount 记录返回数
     * @return 返回指定的记录集
     */
    List<MusicCommentDAO> selectCommentElement(@Param("id") Integer id,
                                               @Param("type") Integer type,
                                               @Param("begin") Integer begin,
                                               @Param("resultCount") Integer resultCount
                                               );

}
