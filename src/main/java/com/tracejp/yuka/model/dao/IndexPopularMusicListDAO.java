package com.tracejp.yuka.model.dao;

/*********************************
 * @author traceJP
 *********************************/
public class IndexPopularMusicListDAO {

    private Integer id;
    private String musicListImgUrl;
    private String musicListName;
    private String musicListType;

    public IndexPopularMusicListDAO() {
    }

    public IndexPopularMusicListDAO(Integer id, String musicListImgUrl, String musicListName, String musicListType) {
        this.id = id;
        this.musicListImgUrl = musicListImgUrl;
        this.musicListName = musicListName;
        this.musicListType = musicListType;
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

    public String getMusicListType() {
        return musicListType;
    }

    public void setMusicListType(String musicListType) {
        this.musicListType = musicListType;
    }

    @Override
    public String toString() {
        return "IndexPopularMusicListDAO{" +
                "id=" + id +
                ", musicListImgUrl='" + musicListImgUrl + '\'' +
                ", musicListName='" + musicListName + '\'' +
                ", musicListType='" + musicListType + '\'' +
                '}';
    }

}
