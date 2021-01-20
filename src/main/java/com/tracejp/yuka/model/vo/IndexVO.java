package com.tracejp.yuka.model.vo;

import com.tracejp.yuka.model.dao.IndexNewSongMusicDAO;
import com.tracejp.yuka.model.dao.IndexPopularMusicListDAO;
import com.tracejp.yuka.model.dao.IndexToDayRankMusicDao;

import java.util.Arrays;

/*********************************
 * @author traceJP
 *********************************/
public class IndexVO {

    private IndexPopularMusicListDAO[] popularMusicList;
    private IndexNewSongMusicDAO[] newSongMusic;
    private IndexToDayRankMusicDao[] rankListOneMusic;
    private IndexToDayRankMusicDao[] rankListTwoMusic;
    private IndexToDayRankMusicDao[] rankListThreeMusic;

    public IndexVO() {
    }

    public IndexVO(IndexPopularMusicListDAO[] popularMusicList,
                   IndexNewSongMusicDAO[] newSongMusic,
                   IndexToDayRankMusicDao[] rankListOneMusic,
                   IndexToDayRankMusicDao[] rankListTwoMusic,
                   IndexToDayRankMusicDao[] rankListThreeMusic) {
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

    public IndexToDayRankMusicDao[] getRankListOneMusic() {
        return rankListOneMusic;
    }

    public void setRankListOneMusic(IndexToDayRankMusicDao[] rankListOneMusic) {
        this.rankListOneMusic = rankListOneMusic;
    }

    public IndexToDayRankMusicDao[] getRankListTwoMusic() {
        return rankListTwoMusic;
    }

    public void setRankListTwoMusic(IndexToDayRankMusicDao[] rankListTwoMusic) {
        this.rankListTwoMusic = rankListTwoMusic;
    }

    public IndexToDayRankMusicDao[] getRankListThreeMusic() {
        return rankListThreeMusic;
    }

    public void setRankListThreeMusic(IndexToDayRankMusicDao[] rankListThreeMusic) {
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
