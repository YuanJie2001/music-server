package com.vector.music.mapper;

import com.vector.music.pojo.Singer;
import com.vector.music.pojo.Song;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 歌曲 Mapper 接口
 * </p>
 *
 * @author YuanJie
 * @since 2022-02-03
 */
public interface SongMapper extends BaseMapper<Song> {
    /**
     * 增加
     */
    public int insert(Song singer);
    /**
     * 修改
     */
    public int update(Song singer);

    /**
     * 删除
     */
    public Integer delete(Integer id);
    /**
     * 根据主键单个查询
     */
    public Song selectByPrimaryKey(Integer id);

    /**
     * 查询所有歌曲
     */
    public List<Song> allSong();
    /**
     * 根据歌曲名精确查询
     */
    public List<Song> songOfName(String name);
    /**
     * 根据歌手id查询
     * @param singerId
     */
    public List<Song> songOfSingerId(Integer singerId);
}
