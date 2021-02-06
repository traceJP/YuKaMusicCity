package com.tracejp.yuka.service.search;

/*********************************
 * @author traceJP
 *********************************/
public interface SearchService<T> {

    /**
     * 搜索查询的总控制方法
     * @param word
     * @param resultCount
     * @return
     */
    T[] searchHandler(String word, Integer resultCount);

    /**
     * 解析查询的关键词，并返回出现第一个冒号前的字符串
     * @param word word
     * @return 如果存在冒号则将 数组0返回冒号前的关键词，数组1返回冒号后的关键词
     *         不存在冒号则将  数组0返回null，数组1返回原词
     */
    String[] parsingKeyWord(String word);

}
