package com.vector.music.service.impl;

import com.vector.music.pojo.Comment;
import com.vector.music.mapper.CommentMapper;
import com.vector.music.service.ICommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
