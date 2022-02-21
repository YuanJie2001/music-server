package com.vector.music.service.impl;

import com.vector.music.pojo.User;
import com.vector.music.mapper.UserMapper;
import com.vector.music.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    @Autowired
    private UserMapper userMapper;
    @Override
    public boolean insert(User user) {
        return userMapper.insert(user)>0;
    }

    @Override
    public boolean update(User user) {
        return userMapper.update(user)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return userMapper.delete(id)>0;
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> allUser() {
        return userMapper.allUser();
    }

    @Override
    public List<User> userOfName(String name) {
        return userMapper.userOfName(name);
    }

    @Override
    public boolean verifyPassword(String username, String password) {
        return userMapper.verifyPassword(username,password)>0;
    }

    @Override
    public User getByUsername(String username) {
        return userMapper.getByUsername(username);
    }
}
