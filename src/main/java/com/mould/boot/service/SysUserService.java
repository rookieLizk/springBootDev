package com.mould.boot.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.mould.boot.dataobject.SysUser;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lizk
 * @since 2019-08-18
 */
public interface SysUserService extends IService<SysUser> {

    List<SysUser> findListBy();
}
