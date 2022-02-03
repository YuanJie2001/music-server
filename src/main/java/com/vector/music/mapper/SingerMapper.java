package com.vector.music.mapper;

import com.vector.music.pojo.Singer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 歌手 Mapper 接口
 * </p>
 *
 * @author YuanJie
 * @since 2022-01-31
 */
@Repository
public interface SingerMapper extends BaseMapper<Singer> {
    /**
     * 增加
     */
    public int insert(Singer singer);
    /**
     * 修改
     */
    public int update(Singer singer);

    /**
     * 删除
     */
    public Integer delete(Integer id);
    /**
     * 根据主键单个查询
     */
    public Singer selectByPrimaryKey(Integer id);

    /**
     * 查询所有歌手
     */
    public List<Singer> allSinger();
    /**
     * 根据歌手名模糊查询
     */
    public List<Singer> singerOfName(String name);
    /**
     * 根据性别查询
     * @param Gender
     */
    public List<Singer> singerOfGender(Byte Gender);
}
