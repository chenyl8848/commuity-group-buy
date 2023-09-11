package com.cyl.gropubuy.admin.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cyl.groupbuy.model.entity.auth.SysMenu;

/**
 * @author：Java陈序员
 * @date：2023/9/11 17:19
 * @description：菜单管理接口
 */
public interface ISysMenuService extends IService<SysMenu> {

    public void add(SysMenu sysMenu);

    public void update(SysMenu sysMenu);
}
