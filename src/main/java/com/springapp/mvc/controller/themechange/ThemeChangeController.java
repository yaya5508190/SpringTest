package com.springapp.mvc.controller.themechange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ThemeResolver;
import org.springframework.web.servlet.theme.SessionThemeResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Alucard on 2014/10/8.
 */
@Controller
@RequestMapping("/changeTheme")
public class ThemeChangeController {
    ThemeResolver themeResolver;
    @RequestMapping("/set")
    public void changeTheme(HttpServletRequest request,HttpServletResponse response,String themeName){
        themeResolver.setThemeName(request,response,themeName);
    }

    @Resource
    public void setThemeResolver(ThemeResolver themeResolver) {
        this.themeResolver = themeResolver;
    }
}
