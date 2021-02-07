package com.tracejp.yuka.model.vo;

/*********************************
 * @author traceJP
 *********************************/
public class MusicCollectVO {

    private Integer id;
    private String musicListName;
    private String musicListImgUrl;
    private Integer musicCount;
    private Boolean hasMusic;

    public MusicCollectVO() {
    }

    public MusicCollectVO(Integer id, String musicListName, String musicListImgUrl, Integer musicCount, Boolean hasMusic) {
        this.id = id;
        this.musicListName = musicListName;
        this.musicListImgUrl = musicListImgUrl;
        this.musicCount = musicCount;
        this.hasMusic = hasMusic;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMusicListName() {
        return musicListName;
    }

    public void setMusicListName(String musicListName) {
        this.musicListName = musicListName;
    }

    public String getMusicListImgUrl() {
        return musicListImgUrl;
    }

    public void setMusicListImgUrl(String musicListImgUrl) {
        this.musicListImgUrl = musicListImgUrl;
    }

    public Integer getMusicCount() {
        return musicCount;
    }

    public void setMusicCount(Integer musicCount) {
        this.musicCount = musicCount;
    }

    public Boolean getHasMusic() {
        return hasMusic;
    }

    public void setHasMusic(Boolean hasMusic) {
        this.hasMusic = hasMusic;
    }

    @Override
    public String toString() {
        return "MusicCollectVO{" +
                "id=" + id +
                ", musicListName='" + musicListName + '\'' +
                ", musicListImgUrl='" + musicListImgUrl + '\'' +
                ", musicCount=" + musicCount +
                ", hasMusic=" + hasMusic +
                '}';
    }

}
