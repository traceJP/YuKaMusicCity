package com.tracejp.yuka.controller;

import com.tracejp.yuka.service.behavior.UserBehaviorService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/*********************************
 * @author traceJP
 *********************************/
@RestController
public class RecordController {

    UserBehaviorService behaviorService;

    @PutMapping("/user/songPlayRecord/{id}")
    public String songPlayRecord(@PathVariable("id") Integer id, String uid) {
        return behaviorService.listenToSongRecord(id, uid);
    }

    @PutMapping("/listClickVolume/{id}")
    public String listClickVolume(@PathVariable("id") Integer id) {
        return behaviorService.listClickVolume(id);
    }

}
