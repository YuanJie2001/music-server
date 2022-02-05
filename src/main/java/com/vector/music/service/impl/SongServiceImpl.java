package com.vector.music.service.impl;

import com.vector.music.pojo.Singer;
import com.vector.music.pojo.Song;
import com.vector.music.mapper.SongMapper;
import com.vector.music.service.ISongService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 歌曲 服务实现类
 * </p>
 *
 * @author YuanJie
 * @since 2022-02-03
 */
@Service
public class SongServiceImpl extends ServiceImpl<SongMapper, Song> implements ISongService {
    @Autowired
    private SongMapper songMapper;
    @Override
    public boolean insert(Song song) {
        return songMapper.insert(song)>0;
    }

    @Override
    public boolean update(Song song) {
        return songMapper.update(song)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return songMapper.delete(id)>0;
    }

    @Override
    public Singer selectByPrimaryKey(Integer id) {
        return songMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Singer> allSong() {
        return songMapper.allSong();
    }

    @Override
    public List<Singer> songOfName(String name) {
        return songMapper.songOfName(name);
    }

    @Override
    public List<Singer> songOfSingerId(Integer singerId) {
        return songMapper.songOfSingerId(singerId);
    }
}
