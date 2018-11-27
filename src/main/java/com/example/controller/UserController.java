package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

/**
 * 处理用户 CRUD 请求
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 得到所有用户/来到列表页面
     *
     * @return
     */
    @RequestMapping("/users")
    public String getAllUser(Map<String, Object> map) {
        map.put("users", userService.getAllUser());
        return "list";
    }


    /**
     * 来到添加页面，GET请求
     *
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String input(Map<String, Object> map) {
        map.put("user", new User());
        return "input";
    }

    /**
     * 执行新增操作
     *
     * @param user 传入的对象，支持 JSR303 校验
     * @return 重定向到列表页面
     */
    @RequestMapping(value = "user", method = RequestMethod.POST)
    public String addUser(@Valid User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id) {
        userService.delete(id);
        return "redirect:/users";
    }

    /**
     * 来到修改页面，GET 请求
     *
     * @param id  传递的标识id
     * @param map 回显数据的存放
     * @return 返回页面
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String input(@PathVariable("id") Integer id, Map<String, Object> map) {
        map.put("user", userService.findUserById(id));
        return "input";
    }

    /**
     * @param id  标识
     * @param map 回显数据，保证数据的完整性
     */
    @ModelAttribute
    public void getUser(@RequestParam(value = "id", required = false) Integer id,
                        Map<String, Object> map) {
        /* id 不为空，说明为修改操作*/
        if (id != null) {
            map.put("user", userService.findUserById(id));
        }
    }

    /**
     * 修改操作
     *
     * @param user 传递回来的 employee 对象
     * @return 重定向到列表页面
     */
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String update(User user) {
        userService.update(user);
        return "redirect:/users";
    }
}
