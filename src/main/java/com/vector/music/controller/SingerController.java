package com.vector.music.controller;


import com.alibaba.fastjson.JSONObject;
import com.vector.music.pojo.Singer;
import com.vector.music.service.ISingerService;
import com.vector.music.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 歌手 前端控制器
 * </p>
 *
 * @author YuanJie
 * @since 2022-01-31
 */
@Controller
@RequestMapping("/singer")
public class SingerController {
    @Autowired
    private ISingerService singerService;

    /**
     * 增添歌手
     */
    @PostMapping("/add")
    @ResponseBody
    public Object addSinger(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String name = request.getParameter("name").trim();
        String gender = request.getParameter("gender").trim();
        String birth = request.getParameter("birth").trim();
        String location = request.getParameter("location").trim();
        String introduction = request.getParameter("introduction").trim();
        String avator = request.getParameter("avator").trim();
        // LocalDateTime格式必须为 yyyy-MM-ddTHH:mm:ss
        LocalDateTime birthDate = LocalDateTime.parse(birth + "T00:00:00");
        Singer singer = new Singer();
        singer.setName(name);
        singer.setGender(Integer.parseInt(gender));
        singer.setBirth(birthDate);
        singer.setLocation(location);
        singer.setIntroduction(introduction);
        singer.setAvator(avator);
        boolean flag = singerService.insert(singer);
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
     * 修改歌手
     */
    @PostMapping("/update")
    @ResponseBody
    public Object updateSinger(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String id = request.getParameter("id").trim();
        String name = request.getParameter("name").trim();
        String gender = request.getParameter("gender").trim();
        String birth = request.getParameter("birth").trim();
        String location = request.getParameter("location").trim();
        String introduction = request.getParameter("introduction").trim();
        // LocalDateTime格式必须为 yyyy-MM-ddTHH:mm:ss
        LocalDateTime birthDate = LocalDateTime.parse(birth + "T00:00:00");
        Singer singer = new Singer();
        singer.setId(Integer.valueOf(id));
        singer.setName(name);
        singer.setGender(Integer.parseInt(gender));
        singer.setBirth(birthDate);
        singer.setLocation(location);
        singer.setIntroduction(introduction);
        boolean flag = singerService.update(singer);
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
     * 删除歌手
     */
    @GetMapping("/delete")
    @ResponseBody
    public Object deleteSinger(HttpServletRequest request) {
        String id = request.getParameter("id").trim();
        return singerService.delete(Integer.parseInt(id));
    }

    /**
     * 根据主键单个查询
     */
    @GetMapping("/selectByPrimaryKey")
    @ResponseBody
    public Object selectByPrimaryKey(HttpServletRequest request) {
        String id = request.getParameter("id").trim();
        return singerService.selectByPrimaryKey(Integer.parseInt(id));
    }

    /**
     * 查询所有歌手
     */
    @GetMapping("/allSinger")
    @ResponseBody
    public List<Singer> allSinger() {
        return singerService.allSinger();
    }

    /**
     * 根据歌手名模糊查询
     */
    @GetMapping("/singerOfName")
    @ResponseBody
    public List<Singer> singerOfName(HttpServletRequest request) {
        String name = request.getParameter("name").trim();
        return singerService.singerOfName("%" + name + "%");
    }

    /**
     * 根据性别查询
     */
    @GetMapping("/singerOfGender")
    @ResponseBody
    public List<Singer> singerOfGender(HttpServletRequest request) {
        String gender = request.getParameter("gender").trim();
        return singerService.singerOfGender(Byte.valueOf(gender));
    }

    /**
     * 更新歌手图片
     */
    @PostMapping("/updateSingerPic")
    @ResponseBody
    public Object updateSingerPic(@RequestParam("file") MultipartFile photo, @RequestParam("id") int id) {
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
                + "singerImages";
        File file = new File(photoPath);
        //判断服务器是否存在该路径
        if (!file.exists()) {
            file.mkdirs();
        }
        //最终文件存放的地址
        String finalPath = photoPath + File.separator + fileName;
        //存储到数据库里的相对文件地址
        String storePhotoPath = "/singerImages/" + fileName;
        //实现上传功能
        try {
            photo.transferTo(new File(finalPath));
            Singer singer = new Singer();
            singer.setId(id);
            singer.setAvator(storePhotoPath);
            boolean flag = singerService.update(singer);
            if (flag) {
                jsonObject.put(Consts.CODE, 1);
                jsonObject.put(Consts.MSG, "文件上传成功");
                return jsonObject;
            }
            jsonObject.put(Consts.CODE, 0);
            jsonObject.put(Consts.MSG, "文件上传失败");
            return jsonObject;
        } catch (IOException e) {
            jsonObject.put(Consts.CODE, 0);
            jsonObject.put(Consts.MSG, "文件上传失败,原因是:" + e.getMessage());
        } finally {
            return jsonObject;
        }
    }

}
