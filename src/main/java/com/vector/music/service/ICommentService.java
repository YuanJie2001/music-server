package com.vector.music.service;

import com.vector.music.pojo.Comment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 评论 服务类
 * </p>
 *
 * @author YuanJie
 * @since 2022-02-03
 */
public interface ICommentService extends IService<Comment> {
    /**
     * 增加
     */
    public boolean insert(Comment comment);
    /**
     * 修改
     */
    public boolean update(Comment comment);

    /**
     * 删除
     */
    public boolean delete(Integer id);
    /**
     * 根据主键单个查询
     */
    public Comment selectByPrimaryKey(Integer id);

    /**
     * 查询所有评论
     */
    public List<Comment> allComment();
    /**
     * 查询某个歌曲下的所有评论
     */
    public List<Comment> commentOfSongId(Integer songId);
    /**
     * 查询某个歌单下的所有评论
     */
    public List<Comment> commentOfSongListId(Integer songListId);
}
