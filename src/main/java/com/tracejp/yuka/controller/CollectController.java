package com.tracejp.yuka.controller;

import com.tracejp.yuka.model.vo.MusicCollectVO;
import com.tracejp.yuka.service.collect.MusicCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/*********************************
 * @author traceJP
 *********************************/
@Controller
@ResponseBody
@RequestMapping("/user")
public class CollectController {

    @Autowired
    MusicCollectService collectService;

    @PostMapping("/addCollect")
    public String collectMusic(Integer musicId, Integer listId, @RequestParam("uid") String uid) {
        return collectService.addCollect(musicId, listId, uid);
    }

    @DeleteMapping("/deleteCollect")
    public String cancelCollect(Integer musicId, Integer listId, @RequestParam("uid") String uid) {
        return collectService.cancelCollect(musicId, listId, uid);
    }

    @GetMapping("/findUserMusicList")
    public MusicCollectVO[] userMusicSelectCollect(Integer musicId, @RequestParam("uid") String uid) {
        return collectService.musicCollectSelectList(musicId, uid);
    }

}
