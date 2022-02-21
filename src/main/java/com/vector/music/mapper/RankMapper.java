package com.vector.music.mapper;

import com.vector.music.pojo.Rank;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 评价 Mapper 接口
 * </p>
 *
 * @author YuanJie
 * @since 2022-02-03
 */
@Repository
public interface RankMapper extends BaseMapper<Rank> {
    /**
     * 增加
     */
    public int insert(Rank rank);

    /**
     * 查总分
     */
    public int selectScoreSum(Integer songListId);

    /**
     * 查总评分人数
     */
    public int selectRankNum(Integer songListId);
}
