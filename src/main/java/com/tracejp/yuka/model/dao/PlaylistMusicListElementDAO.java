package com.tracejp.yuka.model.dao;

/*********************************
 * @author traceJP
 *********************************/
public class PlaylistMusicListElementDAO {

    private Integer id;
    private String musicName;
    private String musicAuthor;

    public PlaylistMusicListElementDAO() {
    }

    public PlaylistMusicListElementDAO(Integer id, String musicName, String musicAuthor) {
        this.id = id;
        this.musicName = musicName;
        this.musicAuthor = musicAuthor;
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

    public String getMusicAuthor() {
        return musicAuthor;
    }

    public void setMusicAuthor(String musicAuthor) {
        this.musicAuthor = musicAuthor;
    }

    @Override
    public String toString() {
        return "PlaylistMusicListElementDAO{" +
                "id=" + id +
                ", musicName='" + musicName + '\'' +
                ", musicAuthor='" + musicAuthor + '\'' +
                '}';
    }

}
