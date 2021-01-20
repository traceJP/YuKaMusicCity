package com.tracejp.yuka.service.base;

import com.tracejp.yuka.model.dao.IndexNewSongMusicDAO;
import com.tracejp.yuka.model.dao.IndexPopularMusicListDAO;
import com.tracejp.yuka.model.dao.IndexToDayRankMusicDao;
import com.tracejp.yuka.service.IndexPageService;
import org.springframework.stereotype.Service;

/*********************************
 * @author traceJP
 *********************************/
@Service
public class IndexPageServiceImpl implements IndexPageService {

    public IndexPopularMusicListDAO[] popularRecommendation() {


        return new IndexPopularMusicListDAO[0];
    }

    public IndexNewSongMusicDAO[] newSongRecommendation() {
        return new IndexNewSongMusicDAO[0];
    }

    public IndexToDayRankMusicDao[] toDayRankOne() {
        return new IndexToDayRankMusicDao[0];
    }

    public IndexToDayRankMusicDao[] toDayRankTwo() {
        return new IndexToDayRankMusicDao[0];
    }

    public IndexToDayRankMusicDao[] toDayRankThree() {
        return new IndexToDayRankMusicDao[0];
    }

}
