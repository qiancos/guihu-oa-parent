package com.atguigu.auth;

import com.atguigu.auth.mapper.SysRoleMapper;
import com.atguigu.model.system.SysRole;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;


@SpringBootTest
public class TestMpDemo1 {

    //注入
    @Autowired
    private SysRoleMapper sysRoleMapper;

    //查询所有记录
    @Test
    public void getAll(){

        List<SysRole> list = sysRoleMapper.selectList(null);
        System.out.println(list);
    }
    //添加操作
    @Test
    public void add(){
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("角色管理员");
        sysRole.setRoleCode("role");
        sysRole.setDescription("角色管理员");

        int result = sysRoleMapper.insert(sysRole);
        System.out.println(result);
        System.out.println(sysRole);


    }
    //修改操作
    @Test
    public void testUpdateById(){
        /*//根据id查询
        SysRole sysRole = new SysRole();
        sysRole.setId(1L);
        sysRole.setRoleName("角色管理员1");

        int result = sysRoleMapper.updateById(sysRole);
        System.out.println(result);
*/
        //根据id查询
        SysRole sysRole = sysRoleMapper.selectById(10);
        //设置修改值
        sysRole.setRoleName("千叶角色管理员");
        //调用方法实现最终修改
        int result = sysRoleMapper.updateById(sysRole);
        System.out.println(result);
    }
    //删除
    /**
     * application-dev.yml 加入配置
     * 此为默认值，如果你的默认值和mp默认的一样，则不需要该配置
     * mybatis-plus:
     * global-config:
     * db-config:
     * logic-delete-value: 1
     * logic-not-delete-value: 0
     */

    @Test
    public void testDeleteById(){
        int result = sysRoleMapper.deleteById(10);
        System.out.println(result);
    }


    //批量删除
    @Test
    public void testDeleteBatchIds(){
        int result = sysRoleMapper.deleteBatchIds(Arrays.asList(1, 1));
        System.out.println(result);
    }

    //条件查询
    @Test
    public void testQuery1(){
        //创建QueryWrapper对象，调用方法封装条件
        QueryWrapper<SysRole>wrapper=new QueryWrapper<>();
        wrapper.eq("role_name","总经理");
        //调用mp方法实现查询操作
        List<SysRole> list = sysRoleMapper.selectList(wrapper);
        System.out.println(list);

    }

    @Test
    public void testQuery2(){
//创建QueryWrapper对象，调用方法封装条件
        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysRole::getRoleName,"总经理");
        //调用mp方法实现查询操作
        List<SysRole> list = sysRoleMapper.selectList(wrapper);
    }
}
