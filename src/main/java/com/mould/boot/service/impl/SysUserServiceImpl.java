package com.mould.boot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mould.boot.dataobject.SysUser;
import com.mould.boot.mapper.SysUserMapper;
import com.mould.boot.service.SysUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lizk
 * @since 2019-08-18
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Override
    public List<SysUser> findListBy() {
        return baseMapper.findListBy();
    }
}
