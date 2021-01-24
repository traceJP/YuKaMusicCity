package com.tracejp.yuka.service.base;

import com.tracejp.yuka.dao.IndexViewPageMapper;
import com.tracejp.yuka.model.dao.IndexNewSongMusicDAO;
import com.tracejp.yuka.model.dao.IndexPopularMusicListDAO;
import com.tracejp.yuka.model.dao.IndexToDayRankMusicDAO;
import com.tracejp.yuka.service.IndexPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*********************************
 * @author traceJP
 *********************************/
// TODO: 2021/1/24 需要改为建造者模式设计 接口需要改为抽象类 命名后缀改为Builder
    // 如果需要传递参数则可以直接在建造者类中创建参数属性，由导演类传入即可
@Service
public class IndexPageServiceImpl implements IndexPageService {

    @Autowired
    private IndexViewPageMapper viewPage;

    public IndexPopularMusicListDAO[] popularRecommendation() {
        List<IndexPopularMusicListDAO> list = viewPage.getMusicListBaseInfoToPopular(POPULAR_RETURN_COUNT);
        return list.toArray(new IndexPopularMusicListDAO[POPULAR_RETURN_COUNT]);
    }

    public IndexNewSongMusicDAO[] newSongRecommendation() {
        List<IndexNewSongMusicDAO> list = viewPage.getMusicBaseInfoToNewSong(NEW_SONG_RETURN_COUNT);
        return list.toArray(new IndexNewSongMusicDAO[NEW_SONG_RETURN_COUNT]);
    }

    public IndexToDayRankMusicDAO[] toDayRankOne() {
        List<IndexToDayRankMusicDAO> list = viewPage.getMusicBaseInfoToRankMusic(TODAY_RANK_RETURN_COUNT);
        return list.toArray(new IndexToDayRankMusicDAO[TODAY_RANK_RETURN_COUNT]);
    }

    public IndexToDayRankMusicDAO[] toDayRankTwo() {
        List<IndexToDayRankMusicDAO> list = viewPage.getMusicBaseInfoToRankMusic(TODAY_RANK_RETURN_COUNT);
        return list.toArray(new IndexToDayRankMusicDAO[TODAY_RANK_RETURN_COUNT]);
    }

    public IndexToDayRankMusicDAO[] toDayRankThree() {
        List<IndexToDayRankMusicDAO> list = viewPage.getMusicBaseInfoToRankMusic(TODAY_RANK_RETURN_COUNT);
        return list.toArray(new IndexToDayRankMusicDAO[TODAY_RANK_RETURN_COUNT]);
    }

}
