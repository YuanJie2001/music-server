package com.vector.music.service;

import com.vector.music.pojo.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 管理员 服务类
 * </p>
 *
 * @author YuanJie
 * @since 2022-01-31
 */
public interface IAdminService extends IService<Admin> {
    /**
     * 验证密码是否正确
     */
    public boolean verifyPassword(String username,String password);
}
