package com.tracejp.yuka.model.dao;

/*********************************
 * @author traceJP
 *********************************/
public class SongMessageDAO {

    private Integer id;
    private String musicImgUrl;
    private String musicName;
    private String musicAuthor;
    private String musicUrl;

    public SongMessageDAO() {
    }

    public SongMessageDAO(Integer id, String musicImgUrl, String musicName, String musicAuthor, String musicUrl) {
        this.id = id;
        this.musicImgUrl = musicImgUrl;
        this.musicName = musicName;
        this.musicAuthor = musicAuthor;
        this.musicUrl = musicUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMusicImgUrl() {
        return musicImgUrl;
    }

    public void setMusicImgUrl(String musicImgUrl) {
        this.musicImgUrl = musicImgUrl;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getMusicAuthor() {
        return musicAuthor;
    }

    public void setMusicAuthor(String musicAuthor) {
        this.musicAuthor = musicAuthor;
    }

    public String getMusicUrl() {
        return musicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
    }

    @Override
    public String toString() {
        return "SongMessageDAO{" +
                "id=" + id +
                ", musicImgUrl='" + musicImgUrl + '\'' +
                ", musicName='" + musicName + '\'' +
                ", musicAuthor='" + musicAuthor + '\'' +
                ", musicUrl='" + musicUrl + '\'' +
                '}';
    }

}
