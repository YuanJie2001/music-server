package com.vector.music.service.impl;

import com.vector.music.pojo.ListContainSong;
import com.vector.music.mapper.ListContainSongMapper;
import com.vector.music.service.IListContainSongService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 歌单包含的歌曲 服务实现类
 * </p>
 *
 * @author YuanJie
 * @since 2022-02-03
 */
@Service
public class ListContainSongServiceImpl extends ServiceImpl<ListContainSongMapper, ListContainSong> implements IListContainSongService {
    @Autowired
    private ListContainSongMapper listContainSongMapper;

    @Override
    public boolean insert(ListContainSong listContainSong) {
        return listContainSongMapper.insert(listContainSong)>0;
    }

    @Override
    public boolean update(ListContainSong listContainSong) {
        return listContainSongMapper.update(listContainSong)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return listContainSongMapper.delete(id)>0;
    }

    @Override
    public ListContainSong selectByPrimaryKey(Integer id) {
        return listContainSongMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ListContainSong> allListContainSong() {
        return listContainSongMapper.allListContainSong();
    }

    @Override
    public List<ListContainSong> listSongOfSongListId(Integer songListId) {
        return listContainSongMapper.listSongOfSongListId(songListId);
    }

    @Override
    public boolean deleteBySongIdAndSongListId(Integer songId, Integer songListId) {
        return listContainSongMapper.deleteBySongIdAndSongListId(songId,songListId)>0;
    }
}
