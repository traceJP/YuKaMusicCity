package com.tracejp.yuka.model.vo;

import com.tracejp.yuka.model.dao.IndexNewSongMusicDAO;
import com.tracejp.yuka.model.dao.IndexPopularMusicListDAO;
import com.tracejp.yuka.model.dao.IndexToDayRankMusicDAO;

import java.util.Arrays;

/*********************************
 * @author traceJP
 *********************************/
public class IndexVO {

    private IndexPopularMusicListDAO[] popularMusicList;
    private IndexNewSongMusicDAO[] newSongMusic;
    private IndexToDayRankMusicDAO[] rankListOneMusic;
    private IndexToDayRankMusicDAO[] rankListTwoMusic;
    private IndexToDayRankMusicDAO[] rankListThreeMusic;

    public IndexVO() {
    }

    public IndexVO(IndexPopularMusicListDAO[] popularMusicList,
                   IndexNewSongMusicDAO[] newSongMusic,
                   IndexToDayRankMusicDAO[] rankListOneMusic,
                   IndexToDayRankMusicDAO[] rankListTwoMusic,
                   IndexToDayRankMusicDAO[] rankListThreeMusic) {
        this.popularMusicList = popularMusicList;
        this.newSongMusic = newSongMusic;
        this.rankListOneMusic = rankListOneMusic;
        this.rankListTwoMusic = rankListTwoMusic;
        this.rankListThreeMusic = rankListThreeMusic;
    }

    public IndexPopularMusicListDAO[] getPopularMusicList() {
        return popularMusicList;
    }

    public void setPopularMusicList(IndexPopularMusicListDAO[] popularMusicList) {
        this.popularMusicList = popularMusicList;
    }

    public IndexNewSongMusicDAO[] getNewSongMusic() {
        return newSongMusic;
    }

    public void setNewSongMusic(IndexNewSongMusicDAO[] newSongMusic) {
        this.newSongMusic = newSongMusic;
    }

    public IndexToDayRankMusicDAO[] getRankListOneMusic() {
        return rankListOneMusic;
    }

    public void setRankListOneMusic(IndexToDayRankMusicDAO[] rankListOneMusic) {
        this.rankListOneMusic = rankListOneMusic;
    }

    public IndexToDayRankMusicDAO[] getRankListTwoMusic() {
        return rankListTwoMusic;
    }

    public void setRankListTwoMusic(IndexToDayRankMusicDAO[] rankListTwoMusic) {
        this.rankListTwoMusic = rankListTwoMusic;
    }

    public IndexToDayRankMusicDAO[] getRankListThreeMusic() {
        return rankListThreeMusic;
    }

    public void setRankListThreeMusic(IndexToDayRankMusicDAO[] rankListThreeMusic) {
        this.rankListThreeMusic = rankListThreeMusic;
    }

    @Override
    public String toString() {
        return "IndexVO{" +
                "popularMusicList=" + Arrays.toString(popularMusicList) +
                ", newSongMusic=" + Arrays.toString(newSongMusic) +
                ", rankListOneMusic=" + Arrays.toString(rankListOneMusic) +
                ", rankListTwoMusic=" + Arrays.toString(rankListTwoMusic) +
                ", rankListThreeMusic=" + Arrays.toString(rankListThreeMusic) +
                '}';
    }

}
