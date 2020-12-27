package com.tracejp.yuka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author JP
 */
@Controller
public class MasterIndexController {

    @GetMapping("/indexView")
    public void indexViewDateModelShow() {
        System.out.println("请求成功");
    }


}
