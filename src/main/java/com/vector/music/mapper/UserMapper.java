package com.vector.music.mapper;

import com.vector.music.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @author YuanJie
 * @since 2022-02-03
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    /**
     * 增加
     */
    public int insert(User user);
    /**
     * 修改
     */
    public int update(User user);

    /**
     * 删除
     */
    public Integer delete(Integer id);
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
     * 验证密码
     */
    public int verifyPassword(String username,String password);
    /**
     * 根据账号查询用户
     */
    public User getByUsername(String username);


}
