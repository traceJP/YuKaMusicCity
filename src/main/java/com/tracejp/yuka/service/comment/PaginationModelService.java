package com.tracejp.yuka.service.comment;

import java.util.List;

/*********************************
 * @author traceJP
 *********************************/
public interface PaginationModelService<T> {

    /**
     * 处理并返回分页数据
     * @param pageNumber 当前页码
     * @param id 歌曲或歌单id
     * @param type 1为歌曲  2为歌单
     * @return 返回记录集合
     */
    List<T> getPaginationService(Integer pageNumber, Integer id, Integer type);

    /**
     * 获取记录总数
     * @param id id
     * @param type type
     * @return
     */
    Integer getElementCount(Integer id, Integer type);

    /**
     * 返回展示所有记录所需要用到的分页数
     * @param elementCount 记录总数
     * @return
     */
    Integer getPaginationCount(Integer elementCount);

    /**
     * 获取记录集开始的元素
     * @param pageNo
     * @return
     */
    Integer getElementBegin(Integer pageNo);

}
