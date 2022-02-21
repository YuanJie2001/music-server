package com.vector.music.service;

import com.vector.music.pojo.Collect;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 收藏 服务类
 * </p>
 *
 * @author YuanJie
 * @since 2022-02-03
 */
public interface ICollectService extends IService<Collect> {
    /**
     * 增加
     */
    public boolean insert(Collect collect);

    /**
     * 删除
     */
    public boolean delete(Integer id);

    /**
     * 根据用户id和歌曲id删除
     */
    public boolean deleteByUserIdSongId(@Param("userId") Integer userId,@Param("songId") Integer songId);
    /**
     * 查询所有收藏
     */
    public List<Collect> allCollect();

    /**
     * 查询某个用户下的所有收藏
     */
    public List<Collect> collectOfUserId(Integer userId);

    /**
     * 查询某个用户是否收藏了某个歌曲
     */
    public boolean existOfSongId(@Param("userId") Integer userId, @Param("songId") Integer songId);
}
