package com.tracejp.yuka.dao;

import com.tracejp.yuka.model.dao.MusicCommentDAO;
import com.tracejp.yuka.model.vo.CommentStatusVO;
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


    /**
     * 向music_comment中添加一条评论记录
     * @param id
     * @param type
     * @param text
     * @param uid
     */
    void insertCommentText(@Param("id") Integer id,
                           @Param("type") Integer type,
                           @Param("text") String text,
                           @Param("uid") String uid);

    /**
     * 查询用户对当前评论的操作状态（单个操作）
     * @param id
     * @param uid
     * @return
     */
    Integer selectCommentStatus(@Param("id") Integer id, @Param("uid") String uid);

    /**
     * 查询用户对当前评论的操作状态（集合操作）
     * @param commentList
     * @param uid
     * @return
     */
    List<CommentStatusVO> selectCommentStatusList(@Param("commentList") Integer[] commentList,
                                                  @Param("uid") String uid);

    /**
     * 替换用户对评论的操作状态
     * @param id
     * @param status
     * @param uid
     */
    void replaceCommentStatus(@Param("id") Integer id, @Param("status") Integer status, @Param("uid") String uid);

    /**
     * 删除点赞，点踩
     * @param id
     * @param uid
     */
    void deleteCommentKeep(@Param("id") Integer id, @Param("uid") String uid);

    /**
     * 对点赞字段进行增减操作
     * @param id
     * @param type type=1时增加 / type=-1时减少
     */
    void updateAddCommentUpvoteNumber(@Param("id") Integer id, @Param("type") Integer type);

    /**
     * 对点踩字段进行增减操作
     * @param id
     * @param type type=1时增加 / type=-1时减少
     */
    void updateAddCommentOpposeNumber(@Param("id") Integer id, @Param("type") Integer type);

}
