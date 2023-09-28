package com.cyl.gropubuy.admin.auth.controller;

import com.cyl.gropubuy.admin.auth.service.ISysMenuService;
import com.cyl.groupbuy.framework.result.Result;
import com.cyl.groupbuy.model.entity.auth.SysMenu;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author：Java陈序员
 * @date：2023/9/11 17:16
 * @description：菜单管理接口
 */
@RestController
@RequestMapping(value = "sysmenu")
@Api(tags = "菜单管理接口")
public class SysMenuController {

    @Resource
    private ISysMenuService sysMenuService;

    @PostMapping("/add")
    @ApiOperation(value = "新增菜单", notes = "新增菜单")
    public Result add(@RequestBody SysMenu sysMenu) {
        sysMenuService.add(sysMenu);
        return Result.success(null);
    }

    @PutMapping("/update")
    @ApiOperation(value = "修改菜单", notes = "修改菜单")
    public Result update(@RequestBody SysMenu sysMenu) {
        sysMenuService.update(sysMenu);
        return Result.success(null);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "删除菜单", notes = "删除菜单")
    public Result delete(@PathVariable("id") String id) {

        sysMenuService.removeById(id);
        return Result.success(null);
    }

    @GetMapping("/get/{id}")
    @ApiOperation(value = "获取菜单信息", notes = "获取菜单信息")
    public Result get(@PathVariable("id") String id) {
        SysMenu sysMenu = sysMenuService.getById(id);
        return Result.success(sysMenu);
    }

}
