package com.zking.ssm.service.Impl;


import com.zking.ssm.mapper.CategoryMapper;
import com.zking.ssm.mapper.NewsMapper;
import com.zking.ssm.model.Category;
import com.zking.ssm.model.News;
import com.zking.ssm.service.INewsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;


public class NewsServiceImplTest extends  BaseTestCase {
    @Autowired
    private INewsService NewsServiceImpl;
    @Autowired
    private CategoryMapper categoryMapper;
    private News news;


    @Before
    public void setUp() throws Exception {
        news = new News();
    }

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
        Category category = new Category();

        news.setTitle("曾波吃屎1");
        news.getNewsId();
        category.setCategoryName("焦点");
        NewsServiceImpl.insert(news);
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByPrimaryKey() {
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }

    @Test
    public void list() {
        List<News> newsList=NewsServiceImpl.list();
        for (News n : newsList) {
            System.out.println(n);
        }
        System.out.println("___________________________");
        newsList=NewsServiceImpl.list();
        for (News n1 : newsList) {
            System.out.println(n1);
        }
    }
}
