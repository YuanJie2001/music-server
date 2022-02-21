package com.vector.music.service.impl;

import com.vector.music.pojo.Rank;
import com.vector.music.mapper.RankMapper;
import com.vector.music.service.IRankService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评价 服务实现类
 * </p>
 *
 * @author YuanJie
 * @since 2022-02-03
 */
@Service
public class RankServiceImpl extends ServiceImpl<RankMapper, Rank> implements IRankService {
    @Autowired
    private RankMapper rankMapper;

    @Override
    public boolean insert(Rank rank) {
        return rankMapper.insert(rank) > 0;
    }

    @Override
    public int selectScoreSum(Integer songListId) {
        return rankMapper.selectScoreSum(songListId);
    }

    @Override
    public int selectRankNum(Integer songListId) {
        return rankMapper.selectRankNum(songListId);
    }

    @Override
    public int getSongAverage(Integer songListId) {
        int num = rankMapper.selectRankNum(songListId);
        if (num == 0) {
            return 5;
        }
        return rankMapper.selectScoreSum(songListId) / num;
    }
}
