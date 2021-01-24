package com.tracejp.yuka.model.bo;

/*********************************
 * @author traceJP
 *********************************/
public class HomeListenToSongsBO {

    private Integer id;
    private String musicName;
    private String musicAuthor;
    private Integer broadcastNumberTimes;
    private Float musicNumberPercentage;

    public HomeListenToSongsBO() {
    }

    public HomeListenToSongsBO(Integer id, String musicName, String musicAuthor, Integer broadcastNumberTimes, Float musicNumberPercentage) {
        this.id = id;
        this.musicName = musicName;
        this.musicAuthor = musicAuthor;
        this.broadcastNumberTimes = broadcastNumberTimes;
        this.musicNumberPercentage = musicNumberPercentage;
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

    public Integer getBroadcastNumberTimes() {
        return broadcastNumberTimes;
    }

    public void setBroadcastNumberTimes(Integer broadcastNumberTimes) {
        this.broadcastNumberTimes = broadcastNumberTimes;
    }

    public Float getMusicNumberPercentage() {
        return musicNumberPercentage;
    }

    public void setMusicNumberPercentage(Float musicNumberPercentage) {
        this.musicNumberPercentage = musicNumberPercentage;
    }

    @Override
    public String toString() {
        return "HomeListenToSongsBO{" +
                "id=" + id +
                ", musicName='" + musicName + '\'' +
                ", musicAuthor='" + musicAuthor + '\'' +
                ", broadcastNumberTimes=" + broadcastNumberTimes +
                ", musicNumberPercentage=" + musicNumberPercentage +
                '}';
    }

}
