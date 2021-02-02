package com.tracejp.yuka.controller;

import com.tracejp.yuka.model.vo.*;
import com.tracejp.yuka.service.BaseViewDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/*********************************
 * @author traceJP
 * 工程下所有视图的请求接收层
 *
 * 无需渲染数据的视图 ： login\registered\myError
 *********************************/
@Controller
@ResponseBody
public class MasterViewController {

    @Autowired
    private BaseViewDataService viewService;

    @GetMapping("/user/userName")
    public String getUserName(HttpSession session) {
        return viewService.getUserName(session);
    }

    @GetMapping("/indexView")
    public IndexVO indexViewDateModelShow() {
        return viewService.builderIndexData();
    }

    @GetMapping("/playlistView/{playlistId}")
    public void playlistViewDateModelShow(@PathVariable("playlistId") Integer playlistId) {
        viewService.builderPlaylistData(playlistId);
    }

    @GetMapping("/songView/{musicId}")
    public SongVO songViewDateModelShow(@PathVariable("musicId") Integer musicId) {
        return viewService.builderSongData(musicId);
    }

    @GetMapping("/user/homeView")
    public HomeVO homeViewDateModelShow(@RequestParam("uid") String uid) {
        return viewService.builderHomeData(uid);
    }

    @GetMapping("/user/myMusicView")
    public MyMusicVO myMusicViewDateModelShow(@RequestParam("uid") String uid) {
        return viewService.builderMyMusicData(uid);
    }

    @GetMapping("/user/updateView")
    public UpdateVO updateViewDateModelShow(@RequestParam("uid") String uid) {
        return viewService.builderUpdateData(uid);
    }

}
