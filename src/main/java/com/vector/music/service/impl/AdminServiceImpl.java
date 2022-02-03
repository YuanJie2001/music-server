package com.vector.music.service.impl;

import com.vector.music.pojo.Admin;
import com.vector.music.mapper.AdminMapper;
import com.vector.music.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员 服务实现类
 * </p>
 *
 * @author YuanJie
 * @since 2022-01-31
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    @Autowired
    private AdminMapper adminMapper;
    /**
     * 验证密码是否正确
     */
    @Override
    public boolean verifyPassword(String username,String password){
        return adminMapper.verifyPassword(username,password)>0;
    };
}