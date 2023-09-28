package com.cyl.gropubuy.admin.auth.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cyl.gropubuy.admin.auth.service.ISysUserService;
import com.cyl.groupbuy.framework.result.Result;
import com.cyl.groupbuy.model.entity.auth.SysUser;
import com.cyl.groupbuy.model.vo.auth.SysUserQueryVo;
import com.google.common.collect.Maps;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author：Java陈序员
 * @date：2023/9/11 15:59
 * @description：用户管理接口
 */
@RestController
@RequestMapping(value = "sysuser")
@Api(tags = "用户管理接口")
public class SysUserController {

    @Resource
    private ISysUserService sysUserService;

    @PostMapping("/add")
    @ApiOperation(value = "新增用户", notes = "新增用户")
    public Result add(@RequestBody SysUser sysUser) {
        sysUserService.add(sysUser);
        return Result.success(null);
    }

    @PutMapping("/update")
    @ApiOperation(value = "修改用户", notes = "修改用户")
    public Result update(@RequestBody SysUser sysUser) {
        sysUserService.update(sysUser);
        return Result.success(null);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "删除用户", notes = "删除用户")
    public Result delete(@PathVariable("id") String id) {

        sysUserService.removeById(id);
        return Result.success(null);
    }

    @GetMapping("/get/{id}")
    @ApiOperation(value = "获取用户信息", notes = "获取用户信息")
    public Result get(@PathVariable("id") String id) {
        SysUser sysUser = sysUserService.getById(id);
        return Result.success(sysUser);
    }

    @PostMapping("/getList/{pageNo}/{pageSize}")
    @ApiOperation(value = "获取用户列表信息", notes = "获取用户列表信息")
    public Result getList(@PathVariable("pageNo") Integer pageNo,
                          @PathVariable("pageSize") Integer pageSize,
                          @RequestBody SysUserQueryVo sysUserQueryVo) {
        Page<SysUser> sysUserPage = sysUserService.getList(pageNo, pageSize, sysUserQueryVo);
        return Result.success(sysUserPage);
    }

    @GetMapping("/getAssignedRole/{id}")
    @ApiOperation(value = "获取已分配的角色信息", notes = "获取已分配的角色信息")
    public Result getAssignedRole(@PathVariable("id") Integer id) {
        return Result.success(null);
    }

    @PostMapping("/assignRole/{id}")
    @ApiOperation(value = "分配角色", notes = "分配角色")
    public Result assignRole(@PathVariable("id") Integer id,
                             @RequestBody Long[] roleIds) {

        return Result.success(null);
    }

    @PostMapping("/login")
    @ApiOperation(value = "登录", notes = "登录")
    public Result login() {

        HashMap<String, Object> resultMap = Maps.newHashMap();

        resultMap.put("token", "123");
        return Result.success(resultMap);
    }

    @PostMapping("/logout")
    @ApiOperation(value = "推出登录", notes = "推出登录")
    public Result logout() {

        return Result.success(null);
    }

    @GetMapping("/getInfo")
    @ApiOperation(value = "获取用户信息", notes = "获取用户信息")
    public Result getInfo() {

        HashMap<String, Object> resultMap = Maps.newHashMap();

        resultMap.put("name", "Super Admin");
        resultMap.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        return Result.success(resultMap);
    }
}
