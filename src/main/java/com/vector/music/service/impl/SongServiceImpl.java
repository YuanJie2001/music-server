package com.vector.music.service.impl;

import com.vector.music.pojo.Song;
import com.vector.music.mapper.SongMapper;
import com.vector.music.service.ISongService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 歌曲 服务实现类
 * </p>
 *
 * @author YuanJie
 * @since 2022-01-31
 */
@Service
public class SongServiceImpl extends ServiceImpl<SongMapper, Song> implements ISongService {

}
