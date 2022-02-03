package com.vector.music.mapper;

import com.vector.music.pojo.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 管理员 Mapper 接口
 * </p>
 *
 * @author YuanJie
 * @since 2022-02-03
 */
@Repository
public interface AdminMapper extends BaseMapper<Admin> {
    /**
     * 验证密码是否正确
     */
    public int verifyPassword(String username,String password);

}
