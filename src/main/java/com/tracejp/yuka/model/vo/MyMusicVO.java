package com.tracejp.yuka.model.vo;

import com.tracejp.yuka.model.dao.MyMusicUserMusicListDAO;

import java.util.Arrays;

/*********************************
 * @author traceJP
 *********************************/
public class MyMusicVO {

    private MyMusicUserMusicListDAO[] create;
    private MyMusicUserMusicListDAO[] favorites;
    private PlaylistVO listVO;

    public MyMusicVO() {
    }

    public MyMusicVO(MyMusicUserMusicListDAO[] create, MyMusicUserMusicListDAO[] favorites, PlaylistVO listVO) {
        this.create = create;
        this.favorites = favorites;
        this.listVO = listVO;
    }

    public MyMusicUserMusicListDAO[] getCreate() {
        return create;
    }

    public void setCreate(MyMusicUserMusicListDAO[] create) {
        this.create = create;
    }

    public MyMusicUserMusicListDAO[] getFavorites() {
        return favorites;
    }

    public void setFavorites(MyMusicUserMusicListDAO[] favorites) {
        this.favorites = favorites;
    }

    public PlaylistVO getListVO() {
        return listVO;
    }

    public void setListVO(PlaylistVO listVO) {
        this.listVO = listVO;
    }

    @Override
    public String toString() {
        return "MyMusicVO{" +
                "create=" + Arrays.toString(create) +
                ", favorites=" + Arrays.toString(favorites) +
                ", listVO=" + listVO +
                '}';
    }

}
