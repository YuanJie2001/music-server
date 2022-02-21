package com.vector.music.controller;


import com.alibaba.fastjson.JSONObject;
import com.vector.music.pojo.Collect;
import com.vector.music.service.ICollectService;
import com.vector.music.utils.Consts;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 * 收藏 前端控制器
 * </p>
 *
 * @author YuanJie
 * @since 2022-02-03
 */
@Controller
@RequestMapping("/collect")
public class CollectController {
    @Autowired
    private ICollectService collectService;

    /**
     * 增添收藏
     */
    @PostMapping("/add")
    @ResponseBody
    public Object addCollect(@RequestBody Collect collect) {
        JSONObject jsonObject = new JSONObject();
        Integer songId = collect.getSongId();
        Integer userId = collect.getUserId();
        if(songId == null){
            jsonObject.put(Consts.CODE, 0);
            jsonObject.put(Consts.MSG, "收藏歌曲为空");
            return jsonObject;
        }
        if(collectService.existOfSongId(userId,songId)){
            jsonObject.put(Consts.CODE, 2);
            jsonObject.put(Consts.MSG, "已收藏");
            return jsonObject;
        }
        boolean flag = collectService.insert(collect);
        if (flag) {
            jsonObject.put(Consts.CODE, 1);
            jsonObject.put(Consts.MSG, "收藏成功");
            return jsonObject;
        }
        jsonObject.put(Consts.CODE, 0);
        jsonObject.put(Consts.MSG, "收藏失败");
        return jsonObject;
    }

    /**
     * 删除收藏
     */
    @GetMapping("/delete")
    @ResponseBody
    public Object deleteCollect(@RequestBody Collect collect) {
        return collectService.delete(collect.getId());
    }
    /**
     * 根据用户id和歌曲id删除
     */
    @GetMapping("/deleteByUserIdSongId")
    @ResponseBody
    public boolean deleteByUserIdSongId(@RequestBody Collect collect){
        return collectService.deleteByUserIdSongId(collect.getUserId(),collect.getSongId());
    };


    /**
     * 某个用户的收藏列表
     */
    @GetMapping("/allCollect")
    @ResponseBody
    public List<Collect> allCollect() {
        return collectService.allCollect();
    }

    /**
     * 查询某个用户的收藏
     */
    @GetMapping("/collectOfUserId")
    @ResponseBody
    public List<Collect> collectOfUserId(@RequestBody Collect collect) {
        return collectService.collectOfUserId(collect.getUserId());
    }

}
