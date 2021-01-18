package com.tracejp.yuka.controller;

import com.tracejp.yuka.model.pojo.RegisteredParameterObject;
import com.tracejp.yuka.service.UserAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/*********************************
 * @author traceJP
 *********************************/
@Controller
public class UserAdminController {

    @Autowired
    private UserAdminService adminService;

    @GetMapping("/registered")
    @ResponseBody
    public int registered(RegisteredParameterObject param) {
        return adminService.registered(param);
    }



}
