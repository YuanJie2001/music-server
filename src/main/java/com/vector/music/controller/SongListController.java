package com.vector.music.controller;


import com.alibaba.fastjson.JSONObject;
import com.vector.music.pojo.Song;
import com.vector.music.pojo.SongList;
import com.vector.music.service.ISongListService;
import com.vector.music.utils.Consts;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
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
@RequestMapping("/songList")
@Slf4j
public class SongListController {
    @Autowired
    private ISongListService songListService;

    /**
     * 增添歌单
     */
    @PostMapping("/add")
    @ResponseBody
    public Object addSongList(@RequestBody SongList songList) {
        JSONObject jsonObject = new JSONObject();
        boolean flag = songListService.insert(songList);
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
     * 修改歌单
     */
    @PostMapping("/update")
    @ResponseBody
    public Object updateSongList(@RequestBody SongList songList) {
        JSONObject jsonObject = new JSONObject();
        boolean flag = songListService.update(songList);
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
     * 删除歌单
     */
    @GetMapping("/delete")
    @ResponseBody
    public Object deleteSongList(@RequestBody SongList songList) {
        return songListService.delete(songList.getId());
    }

    /**
     * 根据主键单个查询
     */
    @GetMapping("/selectByPrimaryKey")
    @ResponseBody
    public Object selectByPrimaryKey(@RequestBody SongList songList) {
        return songListService.selectByPrimaryKey(songList.getId());
    }

    /**
     * 查询所有歌单
     */
    @GetMapping("/allSongList")
    @ResponseBody
    public List<SongList> allSongList() {
        return songListService.allSongList();
    }

    /**
     * 根据标题精确查询
     */
    @GetMapping("/songListOfTitle")
    @ResponseBody
    public List<SongList> songListOfName(@RequestBody SongList songList) {
        return songListService.songListOfTitle(songList.getTitle());
    }
    /**
     * 根据标题模糊查询
     */
    @GetMapping("/likeTitle")
    @ResponseBody
    public List<SongList> likeTitle(@RequestBody SongList songList) {
        return songListService.likeTitle("%" + songList.getTitle() + "%");
    }
    /**
     * 根据风格模糊查询
     */
    @GetMapping("/likeStyle")
    @ResponseBody
    public List<SongList> likeStyle(@RequestBody SongList songList) {
        String style = songList.getStyle();
        return songListService.likeStyle("%" + style + "%");
    }


    /**
     * 更新歌单图片
     */
    @PostMapping("/updateSongListPic")
    @ResponseBody
    public Object updateSongListPic(@RequestParam("file") MultipartFile photo, @RequestParam("id") int id) {
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
                + "songListImages";
        File file = new File(photoPath);
        //判断服务器是否存在该路径
        if (!file.exists()) {
            file.mkdirs();
        }
        //最终文件存放的地址
        String finalPath = photoPath + File.separator + fileName;
        //存储到数据库里的相对文件地址
        String storePhotoPath = "/songListImages/" + fileName;
        //实现上传功能
        try {
            log.info("hi, log..");
            photo.transferTo(new File(finalPath));
            SongList songList = new SongList();
            songList.setId(id);
            songList.setPicture(storePhotoPath);
            boolean flag = songListService.update(songList);
            if (flag) {
                jsonObject.put(Consts.CODE, 1);
                jsonObject.put(Consts.MSG, "文件上传成功");
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

}
