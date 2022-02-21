package com.vector.music.mapper;

import com.vector.music.pojo.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vector.music.pojo.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 评论 Mapper 接口
 * </p>
 *
 * @author YuanJie
 * @since 2022-02-03
 */
@Repository
public interface CommentMapper extends BaseMapper<Comment> {
    /**
     * 增加
     */
    public int insert(Comment comment);
    /**
     * 修改
     */
    public int update(Comment comment);

    /**
     * 删除
     */
    public Integer delete(Integer id);
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
