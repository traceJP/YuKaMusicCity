package com.tracejp.yuka.controller;

import com.tracejp.yuka.model.vo.MusicCollectVO;
import com.tracejp.yuka.service.collect.ListCollectService;
import com.tracejp.yuka.service.collect.MusicCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/*********************************
 * @author traceJP
 *********************************/
@RestController
@RequestMapping("/user")
public class CollectController {

    @Autowired
    MusicCollectService musicService;

    @Autowired
    ListCollectService listService;

    @PostMapping("/addMusicCollect")
    public String collectMusic(Integer musicId, Integer listId, @SessionAttribute String uid) {
        return musicService.addCollect(musicId, listId, uid);
    }

    @DeleteMapping("/deleteMusicCollect")
    public String cancelCollect(Integer musicId, Integer listId, @SessionAttribute String uid) {
        return musicService.cancelCollect(musicId, listId, uid);
    }

    @GetMapping("/findUserMusicList")
    public MusicCollectVO[] userMusicSelectCollect(Integer musicId, @SessionAttribute String uid) {
        return musicService.musicCollectSelectList(musicId, uid);
    }


    @GetMapping("/isUserCreateList")
    public Boolean isUserCreateMusicList(@SessionAttribute String uid, Integer listId) {
        return listService.isUserCreateMusicList(uid, listId);
    }

    @GetMapping("/isUserCollectList")
    public Boolean isUserCollectMusicList(@SessionAttribute String uid, Integer listId) {
        return listService.isUserCollectMusicList(uid, listId);
    }

    @PostMapping("/addMusicList")
    public String createUserMusicList(@SessionAttribute String uid, String listName, String listType, MultipartFile fileImg) {
        return listService.addUserMusicList(uid, listName, listType, fileImg);
    }

    @DeleteMapping("/deleteMusicList")
    public String removeUserMusicList(@SessionAttribute String uid, Integer listId) {
        return listService.removeUserMusicList(uid, listId);
    }

    @PostMapping("/addMusicListCollect")
    public String collectMusicList(@SessionAttribute String uid, Integer listId) {
        return listService.addUserCollectMusicList(uid, listId);
    }

    @DeleteMapping("/deleteMusicListCollect")
    public String cancelMusicListCollect(@SessionAttribute String uid, Integer listId) {
        return listService.removeUserCollectMusicList(uid, listId);
    }

}
