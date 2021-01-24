package com.tracejp.yuka.model.dao;

/*********************************
 * @author traceJP
 *********************************/
public class HomeListenToSongsDAO {

    private Integer id;
    private String musicName;
    private String musicAuthor;
    private Integer broadcastNumberTimes;
    private Integer broadcastNumberTimesTotal;

    public HomeListenToSongsDAO() {
    }

    public HomeListenToSongsDAO(Integer id, String musicName, String musicAuthor, Integer broadcastNumberTimes, Integer broadcastNumberTimesTotal) {
        this.id = id;
        this.musicName = musicName;
        this.musicAuthor = musicAuthor;
        this.broadcastNumberTimes = broadcastNumberTimes;
        this.broadcastNumberTimesTotal = broadcastNumberTimesTotal;
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

    public Integer getBroadcastNumberTimesTotal() {
        return broadcastNumberTimesTotal;
    }

    public void setBroadcastNumberTimesTotal(Integer broadcastNumberTimesTotal) {
        this.broadcastNumberTimesTotal = broadcastNumberTimesTotal;
    }

    @Override
    public String toString() {
        return "HomeListenToSongsDAO{" +
                "id=" + id +
                ", musicName='" + musicName + '\'' +
                ", musicAuthor='" + musicAuthor + '\'' +
                ", broadcastNumberTimes=" + broadcastNumberTimes +
                ", broadcastNumberTimesTotal=" + broadcastNumberTimesTotal +
                '}';
    }

}
