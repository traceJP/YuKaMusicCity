package com.tracejp.yuka.controller;

import com.tracejp.yuka.model.vo.SearchVO;
import com.tracejp.yuka.service.search.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*********************************
 * @author traceJP
 *********************************/
@RestController
public class SearchController {

    @Autowired
    SearchService searchService;

    @GetMapping("/search")
    public SearchVO[] registered(String word, Integer resultCount) {
        return (SearchVO[]) searchService.searchHandler(word, resultCount);
    }

}
