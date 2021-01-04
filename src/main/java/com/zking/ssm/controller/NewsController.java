package com.zking.ssm.controller;


import com.zking.ssm.model.News;
import com.zking.ssm.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/News")
public class NewsController {
    @Autowired
    private INewsService iNewsService;

    @RequestMapping("/news")
    public String News(Model model){
      List<News> news= iNewsService.list();
      model.addAttribute("news",news);
        return "News";
    }




}
