package com.vector.music.controller;


import com.alibaba.fastjson.JSONObject;
import com.vector.music.pojo.ListContainSong;
import com.vector.music.service.IListContainSongService;
import com.vector.music.utils.Consts;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
/**
 * <p>
 * 歌单包含的歌曲 前端控制器
 * </p>
 *
 * @author YuanJie
 * @since 2022-02-03
 */
@Controller
@RequestMapping("/ListContainSong")
public class ListContainSongController {
    @Autowired
    private IListContainSongService listContainSongService;

    /**
     * 给歌单添加歌曲
     */
    @PostMapping("/add")
    @ResponseBody
    public Object addListContainSong(@RequestBody ListContainSong listContainSong) {
        JSONObject jsonObject = new JSONObject();
        boolean flag = listContainSongService.insert(listContainSong);
        if (flag) {
            jsonObject.put(Consts.CODE, 1);
            jsonObject.put(Consts.MSG, "保存成功");
            return jsonObject;
        }
        jsonObject.put(Consts.CODE, 0);
        jsonObject.put(Consts.MSG, "保存失败");
        return jsonObject;
    }

    /**
     * 根据歌单id查询歌曲
     */
    @GetMapping("/listContainSongOfSongId")
    @ResponseBody
    public Object listContainSongOfSongId(@RequestBody ListContainSong listContainSong) {
        return listContainSongService.listSongOfSongListId(listContainSong.getSongListId());
    }

    /**
     * 删除歌单里的歌曲
     */
    @GetMapping("/delete")
    @ResponseBody
    public Object delete(@RequestBody ListContainSong listContainSong) {
        Integer songId = listContainSong.getSongId();
        Integer songListId = listContainSong.getSongListId();
        return listContainSongService.deleteBySongIdAndSongListId(songId, songListId);
    }

}
