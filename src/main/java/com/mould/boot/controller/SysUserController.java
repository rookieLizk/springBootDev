package com.mould.boot.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mould.boot.controller.base.BaseController;
import com.mould.boot.dataobject.SysUser;
import com.mould.boot.exception.MyException;
import com.mould.boot.service.SysUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lizk
 * @since 2019-08-18
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController extends BaseController {
    @Autowired
    private SysUserService sysUserService;

    @ApiOperation("分页查询")
    @GetMapping("/get")
    public IPage<SysUser> find (){
        return sysUserService.page(new Page<>(1,1),new QueryWrapper<SysUser>().eq("name","lizk001"));
    }

    @ApiOperation("查询列表")
    @GetMapping("/find")
    public List<SysUser> findListBy (){
        return sysUserService.findListBy();
    }


    @ApiOperation("异常处理")
    @GetMapping("/throwException")
    public void throwException(){
        throw new MyException("错了");
    }

//    @ApiOperation("插入")
//    @GetMapping("/insert")
//    public SysUser inserSysUser(){
//        SysUser sysUser = new SysUser();
//        sysUser.setName();
//        sysUserService.save();
//    }
}
