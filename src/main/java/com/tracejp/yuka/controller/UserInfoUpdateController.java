package com.tracejp.yuka.controller;

import com.tracejp.yuka.service.admin.UserUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
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
    public String updateUserPassword(@SessionAttribute String uid, String newPassword) {
        return updateService.updateUserPassword(uid, newPassword);
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
    public String updateUserBirthday(@SessionAttribute String uid, Date newBirthday) {
        return updateService.updateUserBirthday(uid, newBirthday);
    }

    @PutMapping("/updateAvatar")
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
