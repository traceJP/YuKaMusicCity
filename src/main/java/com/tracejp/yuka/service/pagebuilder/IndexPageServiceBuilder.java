package com.tracejp.yuka.service.pagebuilder;

import com.tracejp.yuka.dao.IndexViewPageMapper;
import com.tracejp.yuka.model.dao.IndexNewSongMusicDAO;
import com.tracejp.yuka.model.dao.IndexPopularMusicListDAO;
import com.tracejp.yuka.model.dao.IndexToDayRankMusicDAO;
import com.tracejp.yuka.utils.Util;
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
        IndexPopularMusicListDAO[] array = new IndexPopularMusicListDAO[list.size()];
        Util.listTransformArray(list, array);
        return array;
    }

    @Override
    protected IndexNewSongMusicDAO[] newSongRecommendation() {
        List<IndexNewSongMusicDAO> list = viewPage.getMusicBaseInfoToNewSong(NEW_SONG_RETURN_COUNT);
        IndexNewSongMusicDAO[] array = new IndexNewSongMusicDAO[list.size()];
        Util.listTransformArray(list, array);
        return array;
    }

    @Override
    protected IndexToDayRankMusicDAO[] toDayRankOne() {
        List<IndexToDayRankMusicDAO> list = viewPage.getMusicBaseInfoToRankMusic(TODAY_RANK_RETURN_COUNT);
        IndexToDayRankMusicDAO[] array = new IndexToDayRankMusicDAO[list.size()];
        Util.listTransformArray(list, array);
        return array;
    }

    @Override
    protected IndexToDayRankMusicDAO[] toDayRankTwo() {
        List<IndexToDayRankMusicDAO> list = viewPage.getMusicBaseInfoToRankMusic(TODAY_RANK_RETURN_COUNT);
        IndexToDayRankMusicDAO[] array = new IndexToDayRankMusicDAO[list.size()];
        Util.listTransformArray(list, array);
        return array;
    }

    @Override
    protected IndexToDayRankMusicDAO[] toDayRankThree() {
        List<IndexToDayRankMusicDAO> list = viewPage.getMusicBaseInfoToRankMusic(TODAY_RANK_RETURN_COUNT);
        IndexToDayRankMusicDAO[] array = new IndexToDayRankMusicDAO[list.size()];
        Util.listTransformArray(list, array);
        return array;
    }

}
