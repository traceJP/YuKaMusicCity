package com.tracejp.yuka.model.dao;

/*********************************
 * @author traceJP
 *********************************/
public class IndexToDayRankMusicDAO {

    private Integer id;
    private String musicName;

    public IndexToDayRankMusicDAO() {
    }

    public IndexToDayRankMusicDAO(Integer id, String musicName) {
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
        return "IndexToDayRankMusicDAO{" +
                "id=" + id +
                ", musicName='" + musicName + '\'' +
                '}';
    }

}
