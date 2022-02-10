package com.vector.music.service;

import com.vector.music.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author YuanJie
 * @since 2022-02-03
 */
public interface IUserService extends IService<User> {
    /**
     * 增加
     */
    public boolean insert(User user);
    /**
     * 修改
     */
    public boolean update(User user);

    /**
     * 删除
     */
    public boolean delete(Integer id);
    /**
     * 根据主键单个查询
     */
    public User selectByPrimaryKey(Integer id);

    /**
     * 查询所有用户
     */
    public List<User> allUser();
    /**
     * 根据用户名模糊查询
     */
    public List<User> userOfName(String name);
    /**
     * 修改密码
     */
    public int verifyPassword(String username,String password);
    /**
     * 根据账号查询用户
     */
    public User getByUsername(String username);
}
