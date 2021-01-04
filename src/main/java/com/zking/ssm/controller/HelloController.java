package com.zking.ssm.controller;

import com.zking.ssm.model.News;
import com.zking.ssm.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//用于标识处理器类
@RequestMapping("test")
public class HelloController {

    @RequestMapping("/hello")
    //请求到处理器功能方法的映射规则，可定义到类和方法 /hello前台访问地址
    public String hello(){

        return "index";
    }

    //获取前台传过来的参数
     @RequestMapping("/getname")
    public String getparam(String name){
         System.out.println(name);
         return "index";
    }


    @RequestMapping(value = "/getStu/{sid}")
    public String getStu(@PathVariable("sid") String sid){
        System.out.println(sid);
        return "index";
    }



    @RequestMapping(value = "/getstudent")
    @ResponseBody
    //@ResponseBody将前台传过来的参数通过json在页面显示
    public Student getStudent(Student student){
        return student;
    }


    public void list(){

    }

    @RequestMapping(value = "/")
    public String goStudent(Model model){
        News news = new News();
        news.setNewsId(23);
        news.setTitle("哈哈哈哈");
        model.addAttribute("news",news);
        return "index";
    }


  /*  @ModelAttribute
    public void test(){
        System.out.println("非请求处理方法 运行了!!!!");

    }*/







}
