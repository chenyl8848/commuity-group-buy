package com.cyl.gropubuy.admin.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyl.gropubuy.admin.auth.mapper.SysUserMapper;
import com.cyl.gropubuy.admin.auth.service.ISysUserService;
import com.cyl.groupbuy.model.entity.auth.SysUser;
import com.cyl.groupbuy.model.vo.auth.SysUserQueryVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author：Java陈序员
 * @date：2023/9/11 16:41
 * @description：用户管理接口实现类
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Override
    public void add(SysUser sysUser) {
        this.save(sysUser);
    }

    @Override
    public void update(SysUser sysUser) {
        this.updateById(sysUser);
    }

    @Override
    public Page<SysUser> getList(Integer pageNo, Integer pageSize, SysUserQueryVo sysUserQueryVo) {

        Page<SysUser> iPage = new Page<>(pageNo, pageSize);
        LambdaQueryWrapper<SysUser> lambdaQuery = Wrappers.lambdaQuery();
        lambdaQuery.like(StringUtils.isNotBlank(sysUserQueryVo.getUsername()), SysUser::getUsername, sysUserQueryVo.getUsername());
        lambdaQuery.like(StringUtils.isNotBlank(sysUserQueryVo.getName()), SysUser::getName, sysUserQueryVo.getName());

        return page(iPage, lambdaQuery);
    }
}
