package com.tracejp.yuka.controller;

import com.tracejp.yuka.model.dto.RegisteredParameterDTO;
import com.tracejp.yuka.service.admin.UserAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


/*********************************
 * @author traceJP
 *********************************/
@RestController
public class UserAdminController {

    @Autowired
    private UserAdminService adminService;

    @PostMapping("/registered")
    public String registered(RegisteredParameterDTO param) {
        return adminService.registered(param);
    }

    @GetMapping("/login")
    public String loginAttest(String email, String password, Boolean isAutoLogin, HttpSession session) {
        return adminService.loginAttest(email, password, isAutoLogin, session);
    }

    @GetMapping("/hasEmail")
    public String hasEmail(String email) {
        return adminService.hasSameEmail(email);
    }

    @DeleteMapping("/user/loginOut")
    public String loginExit(HttpSession session) {
        return adminService.loginExit(session);
    }



}
