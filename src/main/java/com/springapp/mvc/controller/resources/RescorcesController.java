package com.springapp.mvc.controller.resources;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Alucard on 2014/10/10.
 */
@RequestMapping("/res")
@Controller
public class RescorcesController implements ApplicationContextAware {
    ApplicationContext ctx;
    @RequestMapping("/page")
    public String gotoPage(ModelMap map) throws Exception {
        //classpath资源
        Resource res = ctx.getResource("classpath:test/classpathResourcesTest.txt");
        StringBuffer sb = new StringBuffer();
        BufferedReader reader = new BufferedReader(new InputStreamReader(res.getInputStream()));
        while(reader.ready()){
            sb.append(reader.readLine());
        }
        //http资源
        Resource httpRes = ctx.getResource("http://bbs.saraba1st.com/2b/forum-75-1.html");
        StringBuffer httpSb = new StringBuffer();
        BufferedReader HttpReader = new BufferedReader(new InputStreamReader(httpRes.getInputStream(),"utf8"));
        while(HttpReader.ready()){
            httpSb.append(HttpReader.readLine());
        }
        map.put("resources", httpSb.toString());
        return "resPage";
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }
}
