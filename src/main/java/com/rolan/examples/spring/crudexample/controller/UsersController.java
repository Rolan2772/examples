package com.rolan.examples.spring.crudexample.controller;

import com.rolan.examples.spring.crudexample.dao.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsersController {

    @Autowired
    private UsersDao usersDao;

    @RequestMapping(value = "/showUsers", method = RequestMethod.GET)
    public ModelAndView getUsers() {
        ModelAndView mv = new ModelAndView("/showUsers");
        mv.addObject("users", usersDao.getUsers());
        return mv;
    }
}
