package com.vector.music.controller;


import com.alibaba.fastjson.JSONObject;
import com.vector.music.pojo.Rank;
import com.vector.music.service.IRankService;
import com.vector.music.utils.Consts;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * <p>
 * 评价 前端控制器
 * </p>
 *
 * @author YuanJie
 * @since 2022-02-03
 */
@Controller
@RequestMapping("/rank")
public class RankController {
    @Autowired
    private IRankService rankService;

    /**
     * 新增
     */
    @PostMapping( "/add")
    @ResponseBody
    public Object add(@RequestBody Rank rank){
        JSONObject jsonObject = new JSONObject();
        boolean flag = rankService.insert(rank);
        if (flag){
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"评价成功!");
            return jsonObject;
        }
        jsonObject.put(Consts.CODE,0);
        jsonObject.put(Consts.MSG,"评价失败!");
        return jsonObject;
    }

    /**
     * 计算平均分
     */
    @GetMapping("/average")
    @ResponseBody
    public Object average(@RequestBody Rank rank){
        return rankService.getSongAverage(rank.getSongListId());
    }
}
