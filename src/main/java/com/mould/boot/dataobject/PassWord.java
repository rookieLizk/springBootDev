package com.mould.boot.dataobject;

import com.baomidou.mybatisplus.annotation.TableField;
import com.mould.boot.dataobject.base.BaseDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author lizk
 * @since 2019-11-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="PassWord对象", description="")
public class PassWord extends BaseDO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户表id")
    @TableField("userId")
    private Integer userId;

    @ApiModelProperty(value = "用户名")
    @TableField("userName")
    private String userName;

    @ApiModelProperty(value = "密码biao")
    private String password;


}
