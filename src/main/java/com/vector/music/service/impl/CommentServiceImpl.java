package com.vector.music.service.impl;

import com.vector.music.pojo.Comment;
import com.vector.music.mapper.CommentMapper;
import com.vector.music.service.ICommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 评论 服务实现类
 * </p>
 *
 * @author YuanJie
 * @since 2022-02-03
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public boolean insert(Comment comment) {
        return commentMapper.insert(comment)>0;
    }

    @Override
    public boolean update(Comment comment) {
        return commentMapper.update(comment)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return commentMapper.delete(id)>0;
    }

    @Override
    public Comment selectByPrimaryKey(Integer id) {
        return commentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Comment> allComment() {
        return commentMapper.allComment();
    }

    @Override
    public List<Comment> commentOfSongId(Integer songId) {
        return commentMapper.commentOfSongId(songId);
    }

    @Override
    public List<Comment> commentOfSongListId(Integer songListId) {
        return commentMapper.commentOfSongListId(songListId);
    }
}
