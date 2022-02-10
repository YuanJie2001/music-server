package com.vector.music.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vector.music.pojo.ListContainSong;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 歌单包含的歌曲 Mapper 接口
 * </p>
 *
 * @author YuanJie
 * @since 2022-02-03
 */
@Repository
public interface ListContainSongMapper extends BaseMapper<ListContainSong> {
    /**
     * 增加
     */
    public int insert(ListContainSong listContainSong);
    /**
     * 修改
     */
    public int update(ListContainSong listContainSong);

    /**
     * 删除
     */
    public Integer delete(Integer id);
    /**
     * 根据主键单个查询
     */
    public ListContainSong selectByPrimaryKey(Integer id);

    /**
     * 查询所有歌曲
     */
    public List<ListContainSong> allListContainSong();

    /**
     * 根据歌单id查询所有歌曲
     * @param songListId
     */
    public List<ListContainSong> listSongOfSongListId(Integer songListId);

    /**
     * 根据歌曲id和歌单id删除
     */
    public int deleteBySongIdAndSongListId(Integer songId,Integer songListId);
}
