package com.tracejp.yuka.controller;

import com.tracejp.yuka.model.vo.IndexVO;
import com.tracejp.yuka.service.BaseViewDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

    /**
     * index.html页面全局返回视图
     */
    @GetMapping("/indexView")
    public IndexVO indexViewDateModelShow() {
        return viewService.builderIndexData();
    }

    @GetMapping("/playlistView")
    public void playlistViewDateModelShow() {

    }

    @GetMapping("/songView")
    public void songViewDateModelShow() {

    }

    @GetMapping("/user/homeView")
    public void homeViewDateModelShow(@RequestParam(value = "uid") String uid) {
        viewService.builderHomeData(uid);
    }

    @GetMapping("/user/myMusicView")
    public void myMusicViewDateModelShow() {

    }

    @GetMapping("/user/updateView")
    public void updateViewDateModelShow() {

    }





}
