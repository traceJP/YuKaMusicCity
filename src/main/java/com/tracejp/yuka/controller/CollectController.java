package com.tracejp.yuka.controller;

import com.tracejp.yuka.model.vo.MusicCollectVO;
import com.tracejp.yuka.service.collect.ListCollectService;
import com.tracejp.yuka.service.collect.MusicCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/*********************************
 * @author traceJP
 *********************************/
@Controller
@ResponseBody
@RequestMapping("/user")
public class CollectController {

    @Autowired
    MusicCollectService musicService;

    @Autowired
    ListCollectService listService;

    @PostMapping("/addMusicCollect")
    public String collectMusic(Integer musicId, Integer listId, String uid) {
        return musicService.addCollect(musicId, listId, uid);
    }

    @DeleteMapping("/deleteMusicCollect")
    public String cancelCollect(Integer musicId, Integer listId, String uid) {
        return musicService.cancelCollect(musicId, listId, uid);
    }

    @GetMapping("/findUserMusicList")
    public MusicCollectVO[] userMusicSelectCollect(Integer musicId, String uid) {
        return musicService.musicCollectSelectList(musicId, uid);
    }


    @GetMapping("/isUserCreateList")
    public Boolean isUserCreateMusicList(String uid, Integer listId) {
        return listService.isUserCreateMusicList(uid, listId);
    }

    @GetMapping("/isUserCollectList")
    public Boolean isUserCollectMusicList(String uid, Integer listId) {
        return listService.isUserCollectMusicList(uid, listId);
    }

    @PostMapping("/addMusicList")
    public String createUserMusicList(String uid, String listName, MultipartFile fileImg) {
        return listService.addUserMusicList(uid, listName, fileImg);
    }

    @GetMapping("/deleteMusicList")   // 暂时改get
    public String removeUserMusicList(String uid, Integer listId) {
        return listService.removeUserMusicList(uid, listId);
    }

    @PostMapping("/addMusicListCollect")
    public String collectMusicList(String uid, Integer listId) {
        return listService.addUserCollectMusicList(uid, listId);
    }

    @DeleteMapping("/deleteMusicListCollect")
    public String cancelMusicListCollect(String uid, Integer listId) {
        return listService.removeUserCollectMusicList(uid, listId);
    }

}
