package com.mould.boot.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 外层缓存用户信息
 *
 * @author lizk
 * @date 2019-07-17 10:58
 * @since 1.0.0
 **/
@Data
@NoArgsConstructor
public class UserCacheInfo {

    /** 机构id */
    private String orgId;
    /** 用户id */
    private String userId;
    /** 登录账号 */
    private String userName;
    /** 用户名称 */
    private String fullName;
    /** 集团id */
    private String orgGroupId;
    /** 性别 */
    private String sex;
    /** 是否管理员(0:否;1:是) */
    private String isAdmin;
    /** 头像url */
    private String avatar;
    /** 站点 */
    private String domainName;
    /** 所属部门id */
    private String deptId;
    /** 所属部门名称 */
    private String deptName;
    /** 岗位id */
    private String positionId;
    /** 岗位名称 */
    private String positionName;
    /** toke */
    private String token;
}
