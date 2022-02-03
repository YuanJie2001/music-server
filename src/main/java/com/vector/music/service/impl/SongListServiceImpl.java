package com.vector.music.service.impl;

import com.vector.music.pojo.SongList;
import com.vector.music.mapper.SongListMapper;
import com.vector.music.service.ISongListService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 歌单 服务实现类
 * </p>
 *
 * @author YuanJie
 * @since 2022-02-03
 */
@Service
public class SongListServiceImpl extends ServiceImpl<SongListMapper, SongList> implements ISongListService {

}
