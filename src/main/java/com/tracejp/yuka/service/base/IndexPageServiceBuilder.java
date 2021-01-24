package com.tracejp.yuka.service.base;

import com.tracejp.yuka.dao.IndexViewPageMapper;
import com.tracejp.yuka.model.dao.IndexNewSongMusicDAO;
import com.tracejp.yuka.model.dao.IndexPopularMusicListDAO;
import com.tracejp.yuka.model.dao.IndexToDayRankMusicDAO;
import com.tracejp.yuka.service.IndexPageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*********************************
 * @author traceJP
 *********************************/
@Service
public class IndexPageServiceBuilder extends IndexPageBuilder {

    @Autowired
    private IndexViewPageMapper viewPage;

    @Override
    protected IndexPopularMusicListDAO[] popularRecommendation() {
        List<IndexPopularMusicListDAO> list = viewPage.getMusicListBaseInfoToPopular(POPULAR_RETURN_COUNT);
        return list.toArray(new IndexPopularMusicListDAO[POPULAR_RETURN_COUNT]);
    }

    @Override
    protected IndexNewSongMusicDAO[] newSongRecommendation() {
        List<IndexNewSongMusicDAO> list = viewPage.getMusicBaseInfoToNewSong(NEW_SONG_RETURN_COUNT);
        return list.toArray(new IndexNewSongMusicDAO[NEW_SONG_RETURN_COUNT]);
    }

    @Override
    protected IndexToDayRankMusicDAO[] toDayRankOne() {
        List<IndexToDayRankMusicDAO> list = viewPage.getMusicBaseInfoToRankMusic(TODAY_RANK_RETURN_COUNT);
        return list.toArray(new IndexToDayRankMusicDAO[TODAY_RANK_RETURN_COUNT]);
    }

    @Override
    protected IndexToDayRankMusicDAO[] toDayRankTwo() {
        List<IndexToDayRankMusicDAO> list = viewPage.getMusicBaseInfoToRankMusic(TODAY_RANK_RETURN_COUNT);
        return list.toArray(new IndexToDayRankMusicDAO[TODAY_RANK_RETURN_COUNT]);
    }

    @Override
    protected IndexToDayRankMusicDAO[] toDayRankThree() {
        List<IndexToDayRankMusicDAO> list = viewPage.getMusicBaseInfoToRankMusic(TODAY_RANK_RETURN_COUNT);
        return list.toArray(new IndexToDayRankMusicDAO[TODAY_RANK_RETURN_COUNT]);
    }

}
