package com.vector.music.controller;


import com.alibaba.fastjson.JSONObject;
import com.vector.music.service.IUserService;
import com.vector.music.mapper.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author YuanJie
 * @since 2022-01-31
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping("/login/status")
    public Object loginStatus(HttpServletRequest request, HttpSession session){
        JSONObject jsonObject = new JSONObject();
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        boolean result = userService.verifyPassword(name,password);
        if (result){
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"Login in success!");
            session.setAttribute(Consts.NAME,name);
            return request;
        }
        jsonObject.put(Consts.CODE,0);
        jsonObject.put(Consts.MSG,"Wrong! username or password");
        return jsonObject;

    }

}
