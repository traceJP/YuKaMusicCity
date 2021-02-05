package com.tracejp.yuka.service.pagebuilder;

import com.tracejp.yuka.model.dao.MyMusicUserMusicListDAO;
import com.tracejp.yuka.model.vo.MyMusicVO;

/*********************************
 * @author traceJP
 *********************************/
public abstract class MyMusicPageBuilder extends PlaylistPageServiceBuilder {

    /**
     * 根据uid构建整个页面
     */
    protected String userUid;

    /**
     * 默认页面显示歌单为我喜欢
     */
    protected final Integer iLike = 1;

    /**
     * 我创建的歌单
     * @return
     */
    protected abstract MyMusicUserMusicListDAO[] createMusicList();

    /**
     * 我收藏的歌单
     * @return
     */
    protected abstract MyMusicUserMusicListDAO[] favoritesMusicList();

    /**
     * 通过uid获取用户的默认歌单标识id（我喜欢）
     * @return
     */
    protected abstract Integer getLikeMusicListId();

    /**
     * 构建整个myMusic页面所需要的数据
     * @param userUid
     */
    public MyMusicVO createMyMusicVO(String userUid) {
        this.userUid = userUid;
        return new MyMusicVO(
                createMusicList(),
                favoritesMusicList(),
                createPlaylistVO(getLikeMusicListId())
        );
    }

}
