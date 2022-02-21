package com.vector.music.mapper;

import com.vector.music.pojo.Collect;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vector.music.pojo.Collect;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 收藏 Mapper 接口
 * </p>
 *
 * @author YuanJie
 * @since 2022-02-03
 */
@Repository
public interface CollectMapper extends BaseMapper<Collect> {
    /**
     * 增加
     */
    public int insert(Collect collect);

    /**
     * 删除
     */
    public Integer delete(Integer id);

    /**
     * 根据用户id和歌曲id删除
     */
    public Integer deleteByUserIdSongId(@Param("userId") Integer userId,@Param("songId") Integer songId);
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
    public int existOfSongId(@Param("userId") Integer userId,@Param("songId") Integer songId);
}
