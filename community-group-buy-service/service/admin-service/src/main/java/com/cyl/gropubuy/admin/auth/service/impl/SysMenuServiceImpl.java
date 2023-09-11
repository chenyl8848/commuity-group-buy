package com.cyl.gropubuy.admin.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyl.gropubuy.admin.auth.mapper.SysMenuMapper;
import com.cyl.gropubuy.admin.auth.service.ISysMenuService;
import com.cyl.groupbuy.model.entity.auth.SysMenu;
import org.springframework.stereotype.Service;

/**
 * @author：Java陈序员
 * @date：2023/9/11 17:21
 * @description：菜单管理接口实现类
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {
    @Override
    public void add(SysMenu sysMenu) {
        this.save(sysMenu);
    }

    @Override
    public void update(SysMenu sysMenu) {
        this.updateById(sysMenu);
    }
}
