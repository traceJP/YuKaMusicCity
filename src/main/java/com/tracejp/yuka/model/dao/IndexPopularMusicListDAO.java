package com.tracejp.yuka.model.dao;

/*********************************
 * @author traceJP
 *********************************/
public class IndexPopularMusicListDAO {

    private Integer id;
    private String musicListImgUrl;
    private String musicListName;

    public IndexPopularMusicListDAO() {
    }

    public IndexPopularMusicListDAO(Integer id, String musicListImgUrl, String musicListName) {
        this.id = id;
        this.musicListImgUrl = musicListImgUrl;
        this.musicListName = musicListName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMusicListImgUrl() {
        return musicListImgUrl;
    }

    public void setMusicListImgUrl(String musicListImgUrl) {
        this.musicListImgUrl = musicListImgUrl;
    }

    public String getMusicListName() {
        return musicListName;
    }

    public void setMusicListName(String musicListName) {
        this.musicListName = musicListName;
    }

    @Override
    public String toString() {
        return "MusicListDAO{" +
                "id=" + id +
                ", musicListImgUrl='" + musicListImgUrl + '\'' +
                ", musicListName='" + musicListName + '\'' +
                '}';
    }

}
