package com.tracejp.yuka.controller;

import com.tracejp.yuka.service.admin.UserUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/*********************************
 * @author traceJP
 *********************************/
@RestController
@RequestMapping("/user")
public class UserInfoUpdateController {

    @Autowired
    private UserUpdateService updateService;


    @PutMapping("/updateEmail")
    public String updateUserEmail(@SessionAttribute String uid, String newEmail) {
        return updateService.updateUserEmail(uid, newEmail);
    }

    @PutMapping("/updatePassword")
    public String updateUserPassword(@SessionAttribute String uid, String oldPassword, String newPassword) {
        return updateService.updateUserPassword(uid, oldPassword, newPassword);
    }

    @PutMapping("/updateName")
    public String updateUserName(@SessionAttribute String uid, String newName) {
        return updateService.updateUserName(uid, newName);
    }

    @PutMapping("/updateSex")
    public String updateUserSex(@SessionAttribute String uid, String newSex) {
        return updateService.updateUserSex(uid, newSex);
    }

    @PutMapping("/updateBirthday")
    public String updateUserBirthday(@SessionAttribute String uid, String newBirthday) {
        return updateService.updateUserBirthday(uid, newBirthday);
    }

    @PostMapping("/updateAvatar")
    public String updateUserAvatar(@SessionAttribute String uid, MultipartFile newAvatarFile) {
        return updateService.updateUserAvatar(uid, newAvatarFile);
    }

    @PutMapping("/updateIntroduction")
    public String updateUserIntroduction(@SessionAttribute String uid, String newIntroduction) {
        return updateService.updateUserIntroduction(uid, newIntroduction);
    }

    @PutMapping("/updateArea")
    public String updateUserArea(@SessionAttribute String uid, String newArea) {
        return updateService.updateUserArea(uid, newArea);
    }

}
