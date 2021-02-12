package com.tracejp.yuka.service.pagebuilder;

import com.tracejp.yuka.dao.MyMusicViewMapper;
import com.tracejp.yuka.model.dao.MyMusicUserMusicListDAO;
import com.tracejp.yuka.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

/*********************************
 * @author traceJP
 *********************************/
@Service
@RequestScope
public class MyMusicPageServiceBuilder extends MyMusicPageBuilder {

    @Autowired
    MyMusicViewMapper viewPage;

    @Override
    protected MyMusicUserMusicListDAO[] createMusicList() {
        List<MyMusicUserMusicListDAO> list = viewPage.selectCreateMusicList(userUid);
        MyMusicUserMusicListDAO[] array = new MyMusicUserMusicListDAO[list.size()];
        Util.listTransformArray(list, array);
        return array;
    }

    @Override
    protected MyMusicUserMusicListDAO[] favoritesMusicList() {
        List<MyMusicUserMusicListDAO> list = viewPage.selectFavoritesMusicList(userUid);
        MyMusicUserMusicListDAO[] array = new MyMusicUserMusicListDAO[list.size()];
        Util.listTransformArray(list, array);
        return array;
    }

    @Override
    protected Integer getLikeMusicListId() {
        return viewPage.selectUserILikeMusicListId(userUid);
    }

}
