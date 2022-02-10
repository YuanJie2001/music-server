package com.vector.music.service;

import com.vector.music.pojo.ListContainSong;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 歌单包含的歌曲 服务类
 * </p>
 *
 * @author YuanJie
 * @since 2022-02-03
 */
public interface IListContainSongService extends IService<ListContainSong> {

    /**
     * 增加
     */
    public boolean insert(ListContainSong listContainSong);
    /**
     * 修改
     */
    public boolean update(ListContainSong listContainSong);

    /**
     * 删除
     */
    public boolean delete(Integer id);
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
    public boolean deleteBySongIdAndSongListId(Integer songId,Integer songListId);
}
