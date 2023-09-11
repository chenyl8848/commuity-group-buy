package com.cyl.gropubuy.admin.auth.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cyl.groupbuy.model.entity.auth.SysRole;
import com.cyl.groupbuy.model.vo.auth.SysRoleQueryVo;

/**
 * @author：Java陈序员
 * @date：2023/9/11 16:59
 * @description：角色管理接口
 */
public interface ISysRoleService extends IService<SysRole> {
    public void add(SysRole sysRole);

    public void update(SysRole sysRole);

    public Page<SysRole> getList(Integer pageNo, Integer pageSize, SysRoleQueryVo sysRoleQueryVo);
}
