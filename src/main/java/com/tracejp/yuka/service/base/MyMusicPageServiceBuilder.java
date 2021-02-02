package com.tracejp.yuka.service.base;

import com.tracejp.yuka.dao.MyMusicViewMapper;
import com.tracejp.yuka.model.dao.MyMusicUserMusicListDAO;
import com.tracejp.yuka.service.MyMusicPageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*********************************
 * @author traceJP
 *********************************/
@Service
public class MyMusicPageServiceBuilder extends MyMusicPageBuilder {

    @Autowired
    MyMusicViewMapper viewPage;

    @Override
    protected MyMusicUserMusicListDAO[] createMusicList() {
        List<MyMusicUserMusicListDAO> list = viewPage.selectCreateMusicList(userUid);
        // TODO: 2021/2/2 可以抽象list集合判空方法到util类中
        if(list == null) {
            return null;
        }
        int listSize = list.size();
        return list.toArray(new MyMusicUserMusicListDAO[listSize]);
    }

    @Override
    protected MyMusicUserMusicListDAO[] favoritesMusicList() {
        List<MyMusicUserMusicListDAO> list = viewPage.selectFavoritesMusicList(userUid);
        if(list == null) {
            return null;
        }
        int listSize = list.size();
        return list.toArray(new MyMusicUserMusicListDAO[listSize]);
    }

    @Override
    protected Integer getLikeMusicListId() {
        return viewPage.selectUserILikeMusicListId(userUid);
    }

}
