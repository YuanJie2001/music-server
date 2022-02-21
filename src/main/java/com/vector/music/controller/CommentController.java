package com.vector.music.controller;


import com.alibaba.fastjson.JSONObject;
import com.vector.music.pojo.Comment;
import com.vector.music.service.ICommentService;
import com.vector.music.utils.Consts;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 评论 前端控制器
 * </p>
 *
 * @author YuanJie
 * @since 2022-02-03
 */
@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private ICommentService commentService;

    /**
     * 增添评论
     */
    @PostMapping("/add")
    @ResponseBody
    public Object addComment(@RequestBody Comment comment) {
        JSONObject jsonObject = new JSONObject();
        boolean flag=false;
        if(comment.getContent()!=null && !comment.getContent().equals("")){
            flag = commentService.insert(comment);
        }
        if (flag) {
            jsonObject.put(Consts.CODE, 1);
            jsonObject.put(Consts.MSG, "评论成功");
            return jsonObject;
        }
        jsonObject.put(Consts.CODE, 0);
        jsonObject.put(Consts.MSG, "评论失败");
        return jsonObject;
    }

    /**
     * 修改评论
     */
    @PostMapping("/update")
    @ResponseBody
    public Object updateComment(@RequestBody Comment comment) {
        JSONObject jsonObject = new JSONObject();
        boolean flag = commentService.update(comment);
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
     * 删除评论
     */
    @GetMapping("/delete")
    @ResponseBody
    public Object deleteComment(@RequestBody Comment comment) {
        return commentService.delete(comment.getId());
    }

    /**
     * 根据主键单个查询
     */
    @GetMapping("/selectByPrimaryKey")
    @ResponseBody
    public Object selectByPrimaryKey(@RequestBody Comment comment) {
        return commentService.selectByPrimaryKey(comment.getId());
    }

    /**
     * 查询所有评论
     */
    @GetMapping("/allComment")
    @ResponseBody
    public List<Comment> allComment() {
        return commentService.allComment();
    }

    /**
     * 查询某个歌曲下面的所有评论
     */
    @GetMapping("/commentOfSongId")
    @ResponseBody
    public List<Comment> commentOfSongId(@RequestBody Comment comment) {
        return commentService.commentOfSongId(comment.getSongId());
    }

    /**
     * 查询某个歌单下面的所有评论
     */
    @GetMapping("/commentOfSongListId")
    @ResponseBody
    public List<Comment> commentOfSongListId(@RequestBody Comment comment) {
        return commentService.commentOfSongListId(comment.getSongListId());
    }
}
