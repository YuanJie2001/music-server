package com.vector.music.controller;


import com.alibaba.fastjson.JSONObject;
import com.vector.music.pojo.SongList;
import com.vector.music.pojo.User;
import com.vector.music.service.IUserService;
import com.vector.music.utils.Consts;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author YuanJie
 * @since 2022-02-03
 */
@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private IUserService userService;

    /**
     * 增添用户
     */
    @PostMapping("/add")
    @ResponseBody
    public Object addUser(@RequestBody User user) {
        JSONObject jsonObject = new JSONObject();
        String username = user.getUsername();
        String password = user.getPassword();
        if (username.equals("") || password.equals("")) {
            jsonObject.put(Consts.CODE, 0);
            jsonObject.put(Consts.MSG, "用户名或密码不能为空");
            return jsonObject;
        }
        User u = userService.getByUsername(username);
        if(u != null) {
            jsonObject.put(Consts.CODE, 0);
            jsonObject.put(Consts.MSG, "用户名已存在");
            return jsonObject;
        }
        boolean flag = userService.insert(user);
        if (flag) {
            jsonObject.put(Consts.CODE, 1);
            jsonObject.put(Consts.MSG, "添加成功");
            return jsonObject;
        }
        jsonObject.put(Consts.CODE, 0);
        jsonObject.put(Consts.MSG, "添加失败");
        return jsonObject;
    }

    /**
     * 修改用户
     */
    @PostMapping("/update")
    @ResponseBody
    public Object updateUser(@RequestBody User user) {
        JSONObject jsonObject = new JSONObject();
        boolean flag = userService.update(user);
        if (flag) {
            jsonObject.put(Consts.CODE, 1);
            jsonObject.put(Consts.MSG, "修改成功");
            return jsonObject;
        }
        jsonObject.put(Consts.CODE, 0);
        jsonObject.put(Consts.MSG, "修改失败");
        return jsonObject;
    }

    /**
     * 删除用户
     */
    @GetMapping("/delete")
    @ResponseBody
    public Object deleteUser(@RequestBody User user) {
        return userService.delete(user.getId());
    }

    /**
     * 根据主键单个查询
     */
    @GetMapping("/selectByPrimaryKey")
    @ResponseBody
    public Object selectByPrimaryKey(@RequestBody User user) {
        return userService.selectByPrimaryKey(user.getId());
    }

    /**
     * 查询所有用户
     */
    @GetMapping("/allUser")
    @ResponseBody
    public List<User> allUser() {
        return userService.allUser();
    }

    /**
     * 根据用户名模糊查询
     */
    @GetMapping("/userOfName")
    @ResponseBody
    public List<User> userOfName(@RequestBody User user) {
        String name = user.getUsername();
        return userService.userOfName("%" + name + "%");
    }


    /**
     * 更新用户图片
     */
    @PostMapping("/updateUserPic")
    @ResponseBody
    public Object updateUserPic(@RequestParam("file") MultipartFile photo, @RequestParam("id") int id) {
        JSONObject jsonObject = new JSONObject();
        if (photo.isEmpty()) {
            jsonObject.put(Consts.CODE, 0);
            jsonObject.put(Consts.MSG, "文件上传失败");
            return jsonObject;
        }
        //获取上传的文件的文件名
        String fileName = photo.getOriginalFilename();
        //处理文件重名问题
        //重名问题是java.io中写入同一文件默认覆盖原文件内容导致图片被覆盖.
        //获取文件名后缀
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //将UUID作为文件名  uuid是32位随机数,几乎不可能会重复
        fileName = UUID.randomUUID().toString() + suffixName;
        //获取上传目标路径 File.separator 获取分隔符为了兼容 linux
        String photoPath = System.getProperty("user.dir") + File.separator + "static" + File.separator
                + "userImages";
        File file = new File(photoPath);
        //判断服务器是否存在该路径
        if (!file.exists()) {
            file.mkdirs();
        }
        //最终文件存放的地址
        String finalPath = photoPath + File.separator + fileName;
        //存储到数据库里的相对文件地址
        String storePhotoPath = "/userImages/" + fileName;
        //实现上传功能
        try {
            photo.transferTo(new File(finalPath));
            User user = new User();
            user.setId(id);
            user.setAvator(storePhotoPath);
            boolean flag = userService.update(user);
            if (flag) {
                jsonObject.put(Consts.CODE, 1);
                jsonObject.put(Consts.MSG, "文件上传成功");
                jsonObject.put("avator", user.getAvator());
                return jsonObject;
            }
            jsonObject.put(Consts.CODE, 0);
            jsonObject.put(Consts.MSG, "文件上传失败");
            return jsonObject;
        } catch (Exception e) {
            jsonObject.put(Consts.CODE, 0);
            jsonObject.put(Consts.MSG, "文件上传失败,原因是:" + e.getMessage());
        } finally {
            return jsonObject;
        }
    }

    /**
     * 前端用户登录
     */
    @PostMapping("/login")
    @ResponseBody
    public Object login(@RequestBody User user) {
        JSONObject jsonObject = new JSONObject();
        String username = user.getUsername(); // 账号
        String password = user.getPassword(); // 密码
        if (username.equals("") || password.equals("")) {
            jsonObject.put(Consts.CODE, 0);
            jsonObject.put(Consts.MSG, "用户名或密码不能为空");
            return jsonObject;
        }
        boolean flag = userService.verifyPassword(username, password);
        if (flag) {
            jsonObject.put(Consts.CODE, 1);
            jsonObject.put(Consts.MSG, "登录成功");
            jsonObject.put("userMsg", userService.getByUsername(username));
            return jsonObject;
        }
        jsonObject.put(Consts.CODE, 0);
        jsonObject.put(Consts.MSG, "用户名或密码错误");
        return jsonObject;
    }

}
