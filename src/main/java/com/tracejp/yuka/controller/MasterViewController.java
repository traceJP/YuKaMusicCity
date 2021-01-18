package com.tracejp.yuka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*********************************
 * @author traceJP
 * 工程下所有视图的请求接收层
 *********************************/
@Controller
public class MasterViewController {

    /**
     * index.html页面全局返回视图
     */
    @GetMapping("/indexView")
    @ResponseBody
    public void indexViewDateModelShow(Model model) {
        System.out.println("已收到请求");
    }


}
