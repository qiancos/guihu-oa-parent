package com.atguigu.auth.controller;


import com.atguigu.auth.service.SysRoleService;
import com.atguigu.common.result.Result;
import com.atguigu.model.system.SysRole;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {


    //http://localhost:8800/admin/system/sysRole

    //注入service
    @Autowired
    private SysRoleService sysRoleService;


    //查询所有
    @ApiOperation("")
    @GetMapping("/findAll")
    public Result<List<SysRole>> findAll(){

        List<SysRole> roleList = sysRoleService.list();
        return Result.ok(roleList);
    }

    //统一返回数据结果
    @GetMapping("/findAll2")
    public Result findAll2(){

        List<SysRole> roleList = sysRoleService.list();
        return Result.ok(roleList);
    }
}
