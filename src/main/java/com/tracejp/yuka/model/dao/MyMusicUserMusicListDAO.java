package com.tracejp.yuka.model.dao;

/*********************************
 * @author traceJP
 *********************************/
public class MyMusicUserMusicListDAO {

    private String musicListName;
    private Integer id;

    public MyMusicUserMusicListDAO() {
    }

    public MyMusicUserMusicListDAO(String musicListName, Integer id) {
        this.musicListName = musicListName;
        this.id = id;
    }

    public String getMusicListName() {
        return musicListName;
    }

    public void setMusicListName(String musicListName) {
        this.musicListName = musicListName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MyMusicUserMusicListDAO{" +
                "musicListName='" + musicListName + '\'' +
                ", id=" + id +
                '}';
    }

}
