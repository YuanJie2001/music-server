package com.vector.music.mapper;

import com.vector.music.pojo.Singer;
import com.vector.music.pojo.Song;
import com.vector.music.pojo.SongList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 歌单 Mapper 接口
 * </p>
 *
 * @author YuanJie
 * @since 2022-02-03
 */
@Repository
public interface SongListMapper extends BaseMapper<SongList> {
    /**
     * 增加
     */
    public int insert(SongList songList);
    /**
     * 修改
     */
    public int update(SongList songList);

    /**
     * 删除
     */
    public Integer delete(Integer id);
    /**
     * 根据主键单个查询
     */
    public SongList selectByPrimaryKey(Integer id);

    /**
     * 查询所有歌单
     */
    public List<SongList> allSongList();
    /**
     * 根据标题精确查询
     */
    public List<SongList> songListOfTitle(String title);

    /**
     * 根据标题模糊查询
     */
    public List<SongList> likeTitle(String title);

    /**
     * 根据风格模糊查询
     */
    public List<SongList> likeStyle(String style);
}
