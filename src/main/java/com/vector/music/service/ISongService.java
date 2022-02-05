package com.vector.music.service;

import com.vector.music.pojo.Singer;
import com.vector.music.pojo.Song;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 歌曲 服务类
 * </p>
 *
 * @author YuanJie
 * @since 2022-02-03
 */

public interface ISongService extends IService<Song> {
    /**
     * 增加
     */
    public boolean insert(Song song);
    /**
     * 修改
     */
    public boolean update(Song song);

    /**
     * 删除
     */
    public boolean delete(Integer id);

    /**
     * 根据主键单个查询
     */
    public Singer selectByPrimaryKey(Integer id);

    /**
     * 查询所有歌手
     */
    public List<Singer> allSong();
    /**
     * 根据歌手名模糊查询
     */
    public List<Singer> songOfName(String name);
    /**
     * 根据性别查询
     */
    public List<Singer> songOfSingerId(Integer singerId);
}
