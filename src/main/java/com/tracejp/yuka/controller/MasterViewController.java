package com.tracejp.yuka.controller;

import com.tracejp.yuka.model.vo.IndexVO;
import com.tracejp.yuka.service.BaseViewDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*********************************
 * @author traceJP
 * 工程下所有视图的请求接收层
 *
 * 无需渲染数据的视图 ： login\registered\myError
 *********************************/
@Controller
@ResponseBody
public class MasterViewController {

//    @Autowired
    private BaseViewDataService viewService;

    /**
     * index.html页面全局返回视图
     */
    @GetMapping("/indexView")
    public IndexVO indexViewDateModelShow() {
        return viewService.builderIndexData();
    }

    @GetMapping("/homeView")
    public void homeViewDateModelShow() {

    }

    @GetMapping("/myMusicView")
    public void myMusicViewDateModelShow() {

    }

    @GetMapping("/playlistView")
    public void playlistViewDateModelShow() {

    }

    @GetMapping("/songView")
    public void songViewDateModelShow() {

    }

    @GetMapping("/updateView")
    public void updateViewDateModelShow() {

    }





}
