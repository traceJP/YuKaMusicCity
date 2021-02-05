package com.tracejp.yuka.controller;

import com.tracejp.yuka.model.dto.RegisteredParameterDTO;
import com.tracejp.yuka.service.admin.UserAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


/*********************************
 * @author traceJP
 *********************************/
@Controller
@ResponseBody
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



}
