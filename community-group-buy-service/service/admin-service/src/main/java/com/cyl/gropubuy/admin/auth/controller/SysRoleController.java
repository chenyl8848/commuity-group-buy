package com.cyl.gropubuy.admin.auth.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cyl.gropubuy.admin.auth.service.ISysRoleService;
import com.cyl.groupbuy.framework.result.Result;
import com.cyl.groupbuy.model.entity.auth.SysRole;
import com.cyl.groupbuy.model.vo.auth.SysRoleQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author：Java陈序员
 * @date：2023/9/11 15:59
 * @description：角色管理接口
 */
@RestController(value = "sysrole")
@Api(tags = "角色管理接口")
public class SysRoleController {

    @Resource
    private ISysRoleService sysRoleService;

    @PostMapping("/add")
    @ApiOperation(value = "新增角色", notes = "新增角色")
    public Result add(@RequestBody SysRole sysRole) {
        sysRoleService.add(sysRole);
        return Result.success(null);
    }

    @PutMapping("/update")
    @ApiOperation(value = "修改角色", notes = "修改角色")
    public Result update(@RequestBody SysRole sysRole) {
        sysRoleService.update(sysRole);
        return Result.success(null);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "删除角色", notes = "删除角色")
    public Result delete(@PathVariable("id") String id) {

        sysRoleService.removeById(id);
        return Result.success(null);
    }

    @GetMapping("/get/{id}")
    @ApiOperation(value = "获取角色信息", notes = "获取角色信息")
    public Result get(@PathVariable("id") String id) {
        SysRole SysRole = sysRoleService.getById(id);
        return Result.success(SysRole);
    }

    @GetMapping("/getList/{pageNo}/{pageSize}")
    @ApiOperation(value = "获取角色列表信息", notes = "获取角色列表信息")
    public Result getList(@PathVariable("pageNo") Integer pageNo,
                          @PathVariable("pageSize") Integer pageSize,
                          @RequestBody SysRoleQueryVo sysRoleQueryVo) {
        Page<SysRole> SysRolePage = sysRoleService.getList(pageNo, pageSize, sysRoleQueryVo);
        return Result.success(SysRolePage);
    }

    @GetMapping("/getAssignedMenu/{id}")
    @ApiOperation(value = "获取已分配的菜单信息", notes = "获取已分配的菜单信息")
    public Result getAssignedMenu(@PathVariable("id") Integer id) {
        return Result.success(null);
    }

    @PostMapping("/assignMenu/{id}")
    @ApiOperation(value = "分配菜单", notes = "分配菜单")
    public Result assignMenu(@PathVariable("id") Integer id,
                             @RequestBody Long[] menuIds) {

        return Result.success(null);

    }

}
