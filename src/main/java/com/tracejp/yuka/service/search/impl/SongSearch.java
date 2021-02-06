package com.tracejp.yuka.service.search.impl;

import com.tracejp.yuka.dao.SearchMapper;
import com.tracejp.yuka.model.vo.SearchVO;
import com.tracejp.yuka.service.search.SearchStrategy;
import com.tracejp.yuka.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*********************************
 * @author traceJP
 * 在此类中定制带有：返回值SearchVO[] 方法后缀StrategyMethod 参数String word, Integer resultCount
 * 即可被反射处理
 *********************************/
@Service
public class SongSearch implements SearchStrategy {

    @Autowired
    SearchMapper searchDAO;

    @Override
    public SearchVO[] defaultStrategyMethod(String word, Integer resultCount) {
        List<SearchVO> list = searchDAO.selectDefaultSearch(word, resultCount);
        SearchVO[] array = new SearchVO[list.size()];
        Util.listTransformArray(list, array);
        return array;
    }

    @Override
    public SearchVO[] musicStrategyMethod(String word, Integer resultCount) {
        List<SearchVO> list = searchDAO.selectMusicSearch(word, resultCount);
        for (SearchVO search : list) {
            search.setType(1);
        }
        SearchVO[] array = new SearchVO[list.size()];
        Util.listTransformArray(list, array);
        return array;
    }

    @Override
    public SearchVO[] listStrategyMethod(String word, Integer resultCount) {
        List<SearchVO> list = searchDAO.selectListSearch(word, resultCount);
        for (SearchVO search : list) {
            search.setType(2);
        }
        SearchVO[] array = new SearchVO[list.size()];
        Util.listTransformArray(list, array);
        return array;
    }

    @Override
    public SearchVO[] authorStrategyMethod(String word, Integer resultCount) {
        List<SearchVO> list = searchDAO.selectAuthorSearch(word, resultCount);
        for (SearchVO search : list) {
            search.setType(1);
        }
        SearchVO[] array = new SearchVO[list.size()];
        Util.listTransformArray(list, array);
        return array;
    }

}
