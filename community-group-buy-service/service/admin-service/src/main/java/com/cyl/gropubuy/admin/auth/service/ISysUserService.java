package com.cyl.gropubuy.admin.auth.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cyl.groupbuy.model.entity.auth.SysUser;
import com.cyl.groupbuy.model.vo.auth.SysUserQueryVo;

/**
 * @author：Java陈序员
 * @date：2023/9/11 16:39
 * @description：用户管理接口类
 */
public interface ISysUserService extends IService<SysUser> {

    public void add(SysUser sysUser);

    public void update(SysUser sysUser);

    public Page<SysUser> getList(Integer pageNo, Integer pageSize, SysUserQueryVo sysUserQueryVo);
}
