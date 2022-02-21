package com.vector.music.service;

import com.vector.music.pojo.Rank;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 评价 服务类
 * </p>
 *
 * @author YuanJie
 * @since 2022-02-03
 */
public interface IRankService extends IService<Rank> {
    /**
     * 增加
     */
    public boolean insert(Rank rank);

    /**
     * 查总分
     */
    public int selectScoreSum(Integer songListId);

    /**
     * 查总评分人数
     */
    public int selectRankNum(Integer songListId);

    /**
     * 计算平均分
     */
    public int getSongAverage(Integer songListId);
}
