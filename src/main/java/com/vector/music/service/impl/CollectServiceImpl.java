package com.vector.music.service.impl;

import com.vector.music.pojo.Collect;
import com.vector.music.mapper.CollectMapper;
import com.vector.music.service.ICollectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 收藏 服务实现类
 * </p>
 *
 * @author YuanJie
 * @since 2022-02-03
 */
@Service
public class CollectServiceImpl extends ServiceImpl<CollectMapper, Collect> implements ICollectService {
    @Autowired
    private CollectMapper collectMapper;
    @Override
    public boolean insert(Collect collect) {
        return collectMapper.insert(collect)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return collectMapper.delete(id)>0;
    }

    @Override
    public boolean deleteByUserIdSongId(Integer userId, Integer songId) {
        return collectMapper.deleteByUserIdSongId(userId, songId)>0;
    }

    @Override
    public List<Collect> allCollect() {
        return collectMapper.allCollect();
    }

    @Override
    public List<Collect> collectOfUserId(Integer userId) {
        return collectMapper.collectOfUserId(userId);
    }

    @Override
    public boolean existOfSongId(Integer userId,Integer songId) {
        return collectMapper.existOfSongId(userId,songId)>0;
    }
}
