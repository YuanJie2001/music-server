package com.vector.music.controller;


import com.alibaba.fastjson.JSONObject;
import com.vector.music.pojo.Singer;
import com.vector.music.service.ISingerService;
import com.vector.music.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
        String avator = request.getParameter("avator").trim();
        DateTimeFormatter DateFormat = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        LocalDateTime birthDate = LocalDateTime.parse(birth, DateFormat);
        Singer singer = new Singer();
        singer.setId(Integer.valueOf(id));
        singer.setName(name);
        singer.setGender(Integer.parseInt(gender));
        singer.setBirth(birthDate);
        singer.setLocation(location);
        singer.setIntroduction(introduction);
        singer.setAvator(avator);
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
    public Object selectByPrimaryKey(HttpServletRequest request){
        String id = request.getParameter("id").trim();
        return singerService.selectByPrimaryKey(Integer.parseInt(id));
    }
    /**
     * 查询所有歌手
     */
    @GetMapping("/allSinger")
    @ResponseBody
    public List<Singer> allSinger(){
        return singerService.allSinger();
    }
    /**
     * 根据歌手名模糊查询
     */
    @GetMapping("/singerOfName")
    @ResponseBody
    public List<Singer> singerOfName(HttpServletRequest request){
        String name = request.getParameter("name").trim();
        return singerService.singerOfName("%" + name + "%");
    }
    /**
     * 根据性别查询
     */
    @GetMapping("/singerOfGender")
    @ResponseBody
    public List<Singer> singerOfGender(HttpServletRequest request){
        String gender = request.getParameter("gender").trim();
        return singerService.singerOfGender(Byte.valueOf(gender));
    }

}
