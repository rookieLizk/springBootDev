package com.mould.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mould.boot.dataobject.SysUser;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lizk
 * @since 2019-08-18
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    List<SysUser> findListBy();
}
