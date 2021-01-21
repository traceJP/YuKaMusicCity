package com.tracejp.yuka.service.base;

import com.tracejp.yuka.dao.ViewPageMapper;
import com.tracejp.yuka.model.dao.IndexNewSongMusicDAO;
import com.tracejp.yuka.model.dao.IndexPopularMusicListDAO;
import com.tracejp.yuka.model.dao.IndexToDayRankMusicDao;
import com.tracejp.yuka.service.IndexPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*********************************
 * @author traceJP
 *********************************/
@Service
public class IndexPageServiceImpl implements IndexPageService {

    @Autowired
    ViewPageMapper viewPage;

    public IndexPopularMusicListDAO[] popularRecommendation() {
        List<IndexPopularMusicListDAO> list = viewPage.getMusicListBaseInfoToPopular(POPULAR_RETURN_COUNT);
        return list.toArray(new IndexPopularMusicListDAO[POPULAR_RETURN_COUNT]);
    }

    public IndexNewSongMusicDAO[] newSongRecommendation() {
        List<IndexNewSongMusicDAO> list = viewPage.getMusicBaseInfoToNewSong(NEW_SONG_RETURN_COUNT);
        return list.toArray(new IndexNewSongMusicDAO[NEW_SONG_RETURN_COUNT]);
    }

    public IndexToDayRankMusicDao[] toDayRankOne() {
        List<IndexToDayRankMusicDao> list = viewPage.getMusicBaseInfoToRankMusic(TODAY_RANK_RETURN_COUNT);
        return list.toArray(new IndexToDayRankMusicDao[TODAY_RANK_RETURN_COUNT]);
    }

    public IndexToDayRankMusicDao[] toDayRankTwo() {
        List<IndexToDayRankMusicDao> list = viewPage.getMusicBaseInfoToRankMusic(TODAY_RANK_RETURN_COUNT);
        return list.toArray(new IndexToDayRankMusicDao[TODAY_RANK_RETURN_COUNT]);
    }

    public IndexToDayRankMusicDao[] toDayRankThree() {
        List<IndexToDayRankMusicDao> list = viewPage.getMusicBaseInfoToRankMusic(TODAY_RANK_RETURN_COUNT);
        return list.toArray(new IndexToDayRankMusicDao[TODAY_RANK_RETURN_COUNT]);
    }

}
