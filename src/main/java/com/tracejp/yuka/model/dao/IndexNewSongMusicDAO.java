package com.tracejp.yuka.model.dao;

/*********************************
 * @author traceJP
 *********************************/
public class IndexNewSongMusicDAO {

    private Integer id;
    private String musicImgUrl;
    private String musicName;
    private String musicAuthor;

    public IndexNewSongMusicDAO() {
    }

    public IndexNewSongMusicDAO(Integer id, String musicImgUrl, String musicName, String musicAuthor) {
        this.id = id;
        this.musicImgUrl = musicImgUrl;
        this.musicName = musicName;
        this.musicAuthor = musicAuthor;
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

    @Override
    public String toString() {
        return "IndexNewSongMusicDAO{" +
                "id=" + id +
                ", musicImgUrl='" + musicImgUrl + '\'' +
                ", musicName='" + musicName + '\'' +
                ", musicAuthor='" + musicAuthor + '\'' +
                '}';
    }

}
