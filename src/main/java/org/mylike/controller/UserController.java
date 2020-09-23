package org.mylike.controller;

import org.mylike.entity.User;
import org.mylike.service.UserService;
import org.mylike.until.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户
 * Created by Administrator on 2020/9/22.
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @param user 添加一名用户
     * @return 添加的用户信息
     * 注册
     */
    @PostMapping("/user")
    public R insertOne(User user){
        user=userService.insert(user);
        if (null==user){
            return R.fail("添加失败!");
        }
        return R.success(user);
    }

    @GetMapping("/user")
    public R selectOne(Integer id){
        User user=this.userService.queryById(id);
        if(null==user)return R.fail("没有该用户");
        return R.success(user);
    }

    /**
     * @param user 通过主键修改user信息
     * @return 修改后的信息
     * 更新
     */
    @PutMapping("/user")
    public R updateOne(User user){
            user=this.userService.update(user);
            if(null==user)return R.fail("更新失败");
            return R.success(user);
    }

    @DeleteMapping("/user")
    public R deleteOne(Integer id){
       boolean or=this.userService.deleteById(id);
       if (!or) return R.fail("删除失败");
       return R.success(1);
    }

    /**
     * @param username 用户名
     * @param password 密码
     * @return 用户信息
     * 登录
     */
    @PostMapping("login")
    public R log(String username,String password){
        User user=this.userService.login(username,password);
        if (null==user)return R.fail("登录失败！");
        return R.success(user);
    }
}
