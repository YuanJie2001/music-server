package com.vector.music.controller;


import com.alibaba.fastjson.JSONObject;
import com.vector.music.pojo.Admin;
import com.vector.music.service.IAdminService;
import com.vector.music.utils.Consts;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * <p>
 * 管理员 前端控制器
 * </p>
 *
 * @author YuanJie
 * @since 2022-01-31
 */

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private IAdminService adminService;

    /**
     * 判断是否登录成功
     */
    @PostMapping( "/login/status")
    @ResponseBody
    public Object loginStatus(@RequestBody Admin admin, HttpSession session){
        JSONObject jsonObject = new JSONObject();
        String name = admin.getName();
        String password = admin.getPassword();
        boolean result = adminService.verifyPassword(name,password);
        if (result){
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"Login in success!");
            session.setAttribute(Consts.NAME,name);
            return jsonObject;
        }
        jsonObject.put(Consts.CODE,0);
        jsonObject.put(Consts.MSG,"Wrong! username or password");
        return jsonObject;

    }
}