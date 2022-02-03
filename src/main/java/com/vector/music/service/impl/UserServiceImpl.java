package com.vector.music.service.impl;

import com.vector.music.pojo.User;
import com.vector.music.mapper.UserMapper;
import com.vector.music.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author YuanJie
 * @since 2022-02-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
