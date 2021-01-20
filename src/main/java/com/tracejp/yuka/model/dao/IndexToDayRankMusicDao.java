package com.tracejp.yuka.model.dao;

/*********************************
 * @author traceJP
 *********************************/
public class IndexToDayRankMusicDao {

    private Integer id;
    private String musicName;

    public IndexToDayRankMusicDao() {
    }

    public IndexToDayRankMusicDao(Integer id, String musicName) {
        this.id = id;
        this.musicName = musicName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    @Override
    public String toString() {
        return "IndexToDayRankMusicDao{" +
                "id=" + id +
                ", musicName='" + musicName + '\'' +
                '}';
    }

}
