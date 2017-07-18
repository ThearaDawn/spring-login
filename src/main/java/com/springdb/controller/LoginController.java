package com.springdb.controller;

import com.springdb.entity.Role;
import com.springdb.entity.User;
import com.springdb.services.RoleService;
import com.springdb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by t.daun on 7/17/2017.
 */
@Controller
public class LoginController {

    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage(@RequestParam(value = "error", required = false) String error) {
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username or password!");
        }
        model.setViewName("login");

        return model;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void test()
    {

        Role role =  roleService.getRoleById(Long.parseLong("1"));

        List<Role>  roles = new ArrayList<>();
        roles.add(role);

        User user = new User();

        user.setDt_cre(new Date());
        user.setDt_upd(new Date());
        user.setEmail("");
        user.setName("admin");
        user.setPassword("123");
        user.setRoles(roles);
        user.setStatus(true);
        user.setUsername("admin");
        user.setUsr_cre("system");
        user.setUsr_upd("system");


        userService.saveUser(user);
    }
}
