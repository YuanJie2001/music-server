package com.vector.music.service.impl;

import com.vector.music.pojo.User;
import com.vector.music.mapper.UserMapper;
import com.vector.music.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author YuanJie
 * @since 2022-01-31
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;
    /**
     * 验证密码是否正确
     */
    @Override
    public boolean verifyPassword(String username, String password) {
        return userMapper.verifyPassword(username,password)>0;
    }
}
