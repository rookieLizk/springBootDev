package com.mould.boot.dataobject;

import com.baomidou.mybatisplus.annotation.SqlCondition;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mould.boot.dataobject.base.BaseDO;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author lizk
 * @since 2019-08-18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SysUser对象", description="嗡嗡嗡")
@TableName("sys_user")
public class SysUser extends BaseDO {

    private static final long serialVersionUID = 1L;

    @TableField("name")
    private String name;

    private String username;

//    @TableField(condition = SqlCondition.LIKE)
    private String password;

    //表中不存在的字段
//    private transient String remark;
//    private static String remark;
    @TableField(exist = false)
    private String remark;

}
