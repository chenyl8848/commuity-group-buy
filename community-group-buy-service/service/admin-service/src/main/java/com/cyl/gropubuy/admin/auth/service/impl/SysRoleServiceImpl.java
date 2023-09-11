package com.cyl.gropubuy.admin.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyl.gropubuy.admin.auth.mapper.SysRoleMapper;
import com.cyl.gropubuy.admin.auth.service.ISysRoleService;
import com.cyl.groupbuy.model.entity.auth.SysRole;
import com.cyl.groupbuy.model.vo.auth.SysRoleQueryVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author：Java陈序员
 * @date：2023/9/11 17:04
 * @description：角色管理接口实现类
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {
    @Override
    public void add(SysRole sysRole) {
        this.save(sysRole);
    }

    @Override
    public void update(SysRole sysRole) {
        this.updateById(sysRole);
    }

    @Override
    public Page<SysRole> getList(Integer pageNo, Integer pageSize, SysRoleQueryVo sysRoleQueryVo) {
        Page<SysRole> iPage = new Page<>(pageNo, pageSize);
        LambdaQueryWrapper<SysRole> lambdaQuery = Wrappers.lambdaQuery();
        lambdaQuery.like(StringUtils.isNotBlank(sysRoleQueryVo.getRoleName()), SysRole::getRoleName, sysRoleQueryVo.getRoleName());

        return page(iPage, lambdaQuery);
    }
}
