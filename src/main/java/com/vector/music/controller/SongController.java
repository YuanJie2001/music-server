package com.vector.music.controller;


import com.alibaba.fastjson.JSONObject;

import com.vector.music.pojo.Song;
import com.vector.music.service.ISongService;
import com.vector.music.utils.Consts;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * <p>
 * 歌曲 前端控制器
 * </p>
 *
 * @author YuanJie
 * @since 2022-02-03
 */
@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private ISongService songService;

    /**
     * 添加歌曲
     */
    @PostMapping("/add")
    @ResponseBody
    public Object addSong(@RequestBody Song song, @RequestParam("file") MultipartFile songFile) {
        JSONObject jsonObject = new JSONObject();
        // 获取前端传来的参数
        String picture = "/songImages/music.png";
        // 上传歌曲文件
        if (songFile.isEmpty()) {
            jsonObject.put(Consts.CODE, 0);
            jsonObject.put(Consts.MSG, "歌曲上传失败");
            return jsonObject;
        }
        //获取上传的文件的文件名
        String fileName = songFile.getOriginalFilename();
        //处理文件重名问题
        //重名问题是java.io中写入同一文件默认覆盖原文件内容导致图片被覆盖.
        //获取文件名后缀
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //将UUID作为文件名  uuid是32位随机数,几乎不可能会重复
        fileName = UUID.randomUUID().toString() + suffixName;
        //获取上传目标路径 File.separator 获取分隔符为了兼容 linux
        String songPath = System.getProperty("user.dir") + File.separator + "static" + File.separator
                + "song";
        File file = new File(songPath);
        //判断服务器是否存在该路径
        if (!file.exists()) {
            file.mkdirs();
        }
        //最终文件存放的地址
        String finalPath = songPath + File.separator + fileName;
        //存储到数据库里的相对文件地址
        String storeUrlPath = "/song/" + fileName;
        //实现上传功能
        try {
            songFile.transferTo(new File(finalPath));
            song.setPicture(picture);
            boolean flag = songService.insert(song);
            if (flag) {
                jsonObject.put(Consts.CODE, 1);
                jsonObject.put(Consts.MSG, "保存成功");
                jsonObject.put("url", storeUrlPath);
                return jsonObject;
            }
            jsonObject.put(Consts.CODE, 0);
            jsonObject.put(Consts.MSG, "保存失败");
            return jsonObject;
        } catch (IOException e) {
            jsonObject.put(Consts.CODE, 0);
            jsonObject.put(Consts.MSG, "保存失败,原因是:" + e.getMessage());
        } finally {
            return jsonObject;
        }
    }

    /**
     * 根据歌手id查询歌曲
     */
    @GetMapping("/songOfSingerId")
    @ResponseBody
    public Object songOfSingerId(@RequestBody Song song) {
        return songService.songOfSingerId(song.getSingerId());
    }

    /**
     * 根据歌曲名精确查询歌曲
     */
    @GetMapping("/songOfSongName")
    @ResponseBody
    public Object songOfSongName(@RequestBody Song song) {
        return songService.songOfName(song.getName());
    }

    /**
     * 修改歌手
     */
    @PostMapping("/update")
    @ResponseBody
    public Object updateSinger(@RequestBody Song song) {
        JSONObject jsonObject = new JSONObject();
        boolean flag = songService.update(song);
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
     * 删除歌曲
     */
    @GetMapping("/delete")
    @ResponseBody
    public Object deleteSinger(@RequestBody Song song) {
        return songService.delete(song.getId());
    }

    /**
     * 更新歌曲图片
     */
    @PostMapping("/updateSongPic")
    @ResponseBody
    public Object updateSongPic(@RequestParam("file") MultipartFile photo, @RequestParam("id") int id) {
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
                + "songImages";
        File file = new File(photoPath);
        //判断服务器是否存在该路径
        if (!file.exists()) {
            file.mkdirs();
        }
        //最终文件存放的地址
        String finalPath = photoPath + File.separator + fileName;
        //存储到数据库里的相对文件地址
        String storePhotoPath = "/songImages/" + fileName;
        //实现上传功能
        try {
            photo.transferTo(new File(finalPath));
            Song song = new Song();
            song.setId(id);
            song.setPicture(storePhotoPath);
            boolean flag = songService.update(song);
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

    /**
     * 更新歌曲
     */
    @PostMapping("/updateSongUrl")
    @ResponseBody
    public Object updateSongUrl(@RequestParam("file") MultipartFile songFile, @RequestParam("id") int id) {
        JSONObject jsonObject = new JSONObject();
        // 上传歌曲文件
        if (songFile.isEmpty()) {
            jsonObject.put(Consts.CODE, 0);
            jsonObject.put(Consts.MSG, "歌曲上传失败");
            return jsonObject;
        }
        //获取上传的文件的文件名
        String fileName = songFile.getOriginalFilename();
        //处理文件重名问题
        //重名问题是java.io中写入同一文件默认覆盖原文件内容导致图片被覆盖.
        //获取文件名后缀
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //将UUID作为文件名  uuid是32位随机数,几乎不可能会重复
        fileName = UUID.randomUUID().toString() + suffixName;
        //获取上传目标路径 File.separator 获取分隔符为了兼容 linux
        String songPath = System.getProperty("user.dir") + File.separator + "static" + File.separator
                + "song";
        File file = new File(songPath);
        //判断服务器是否存在该路径
        if (!file.exists()) {
            file.mkdirs();
        }
        //最终文件存放的地址
        String finalPath = songPath + File.separator + fileName;
        //存储到数据库里的相对文件地址
        String storeUrlPath = "/song/" + fileName;
        //实现上传功能
        try {
            songFile.transferTo(new File(finalPath));
            Song song = new Song();
            song.setId(id);
            song.setUrl(storeUrlPath);
            boolean flag = songService.update(song);
            if (flag) {
                jsonObject.put(Consts.CODE, 1);
                jsonObject.put(Consts.MSG, "保存成功");
                jsonObject.put("url", storeUrlPath);
                return jsonObject;
            }
            jsonObject.put(Consts.CODE, 0);
            jsonObject.put(Consts.MSG, "保存失败");
            return jsonObject;
        } catch (IOException e) {
            jsonObject.put(Consts.CODE, 0);
            jsonObject.put(Consts.MSG, "保存失败,原因是:" + e.getMessage());
        } finally {
            return jsonObject;
        }
    }

    /**
     * 根据歌曲id查询歌曲对象
     */
    @GetMapping("/songOfSongId")
    @ResponseBody
    public Object songOfSongId(@RequestBody Song song) {
        return songService.selectByPrimaryKey(song.getId());
    }

    /**
     * 根据所有歌曲
     */
    @GetMapping("/allSong")
    @ResponseBody
    public Object allSong() {
        return songService.allSong();
    }

}
