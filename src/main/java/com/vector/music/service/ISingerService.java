package com.vector.music.service;

import com.vector.music.pojo.Singer;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 歌手 服务类
 * </p>
 *
 * @author YuanJie
 * @since 2022-01-31
 */
public interface ISingerService extends IService<Singer> {
    /**
     * 增加
     */
    public boolean insert(Singer singer);
    /**
     * 修改
     */
    public boolean update(Singer singer);

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
    public List<Singer> allSinger();
    /**
     * 根据歌手名模糊查询
     */
    public List<Singer> singerOfName(String name);
    /**
     * 根据性别查询
     */
    public List<Singer> singerOfGender(Byte gender);

}
