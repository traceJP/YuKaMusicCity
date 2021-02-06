package com.tracejp.yuka.service.search.impl;

import com.tracejp.yuka.model.vo.SearchVO;
import com.tracejp.yuka.service.search.SearchService;
import com.tracejp.yuka.service.search.SearchStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*********************************
 * @author traceJP
 *********************************/
@Service
public class SearchServiceImpl implements SearchService<SearchVO> {

    private static final String SUFFIX = "StrategyMethod";

    @Autowired
    SearchStrategy strategy;

    @Override
    public SearchVO[] searchHandler(String word, Integer resultCount) {
        String[] parsingArray = parsingKeyWord(word);
        String parsingKey = parsingArray[0] + SUFFIX;
        SearchVO[] searchVO = null;
        Class<?> clazz = strategy.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        boolean hasMethod = false;
        // 遍历查找是否存在具有关键词的方法
        for(Method method : methods) {
            if(parsingKey.equals(method.getName())) {
                try {
                    searchVO = (SearchVO[]) method.invoke(strategy, parsingArray[1], resultCount);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                hasMethod = true;
            }
        }
        // 不存在具有关键词的方法：调用默认策略进行查找并返回
        if(!hasMethod) {
            searchVO = strategy.defaultStrategyMethod(word, resultCount);
        }
        return searchVO;
    }

    @Override
    public String[] parsingKeyWord(String word) {
        String[] res = new String[2];
        String remove = word.replace(" ", "");
        String head = remove.replace('：', ':');
        int index = head.indexOf(":");
        if(index == -1) {
            res[1] = word;
            return res;
        }
        res[0] = head.substring(0, index);
        res[1] = head.substring(index + 1);
        return res;
    }

}
