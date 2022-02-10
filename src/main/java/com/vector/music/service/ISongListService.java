package com.vector.music.service;

import com.vector.music.pojo.Singer;
import com.vector.music.pojo.SongList;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 歌单 服务类
 * </p>
 *
 * @author YuanJie
 * @since 2022-02-03
 */
public interface ISongListService extends IService<SongList> {
    /**
     * 增加
     */
    public boolean insert(SongList songList);

    /**
     * 修改
     */
    public boolean update(SongList songList);

    /**
     * 删除
     */
    public boolean delete(Integer id);

    /**
     * 根据主键单个查询
     */
    public SongList selectByPrimaryKey(Integer id);

    /**
     * 查询所有歌单
     */
    public List<SongList> allSongList();

    /**
     * 根据标题模糊查询
     */
    public List<SongList> songListOfTitle(String title);

    /**
     * 根据标题精确查询
     */
    public List<SongList> likeTitle(String title);

    /**
     * 根据风格模糊查询
     */
    public List<SongList> likeStyle(String style);
}
