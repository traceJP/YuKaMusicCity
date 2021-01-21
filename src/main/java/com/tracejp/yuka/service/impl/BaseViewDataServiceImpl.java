package com.tracejp.yuka.service.impl;

import com.tracejp.yuka.model.vo.IndexVO;
import com.tracejp.yuka.service.BaseViewDataService;
import com.tracejp.yuka.service.IndexPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*********************************
 * @author traceJP
 *********************************/
@Service
public class BaseViewDataServiceImpl implements BaseViewDataService {

    @Autowired
    IndexPageService indexService;

    public IndexVO builderIndexData() {
        return new IndexVO(indexService.popularRecommendation(),
                indexService.newSongRecommendation(),
                indexService.toDayRankOne(),
                indexService.toDayRankTwo(),
                indexService.toDayRankThree()
        );
    }
}
