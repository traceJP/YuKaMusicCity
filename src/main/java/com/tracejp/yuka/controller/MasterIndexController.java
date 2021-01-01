package com.tracejp.yuka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author JP
 */
@Controller("/index")
public class MasterIndexController {

    /**
     * index.html页面全局返回视图
     */
    @GetMapping("/indexView")
    public void indexViewDateModelShow() {
        System.out.println("请求成功");
    }


}
