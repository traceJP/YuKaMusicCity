package com.tracejp.yuka.service.search;

import com.tracejp.yuka.model.vo.SearchVO;

/*********************************
 * @author traceJP
 *********************************/
public interface SearchStrategy {

    /**
     * 采用默认搜索歌曲策略的方法
     * @param word
     * @param resultCount
     * @return
     */
    SearchVO[] defaultStrategyMethod(String word, Integer resultCount);

    /**
     * 采用只搜索歌曲策略的方法
     * @param resultCount
     * @param word
     * @return
     */
    SearchVO[] musicStrategyMethod(String word, Integer resultCount);

    /**
     * 采用只搜索歌单策略的方法
     * @param resultCount
     * @param word
     * @return
     */
    SearchVO[] listStrategyMethod(String word, Integer resultCount);

    /**
     * c采用只通过搜索作者的策略方法
     * @param resultCount
     * @param word
     * @return
     */
    SearchVO[] authorStrategyMethod(String word, Integer resultCount);

}
