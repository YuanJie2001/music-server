package com.vector.music.mapper;

import com.vector.music.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @author YuanJie
 * @since 2022-01-31
 */

public interface UserMapper extends BaseMapper<User> {
    /**
     * 验证密码是否正确
     */
    public int verifyPassword(String username,String password);
}
