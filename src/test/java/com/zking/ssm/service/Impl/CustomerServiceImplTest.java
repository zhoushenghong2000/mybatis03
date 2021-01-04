package com.zking.ssm.service.Impl;


import com.zking.ssm.mapper.OrderMapper;
import com.zking.ssm.model.Customer;
import com.zking.ssm.model.Order;
import com.zking.ssm.service.ICustomerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class CustomerServiceImplTest extends BaseTestCase{
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private OrderMapper orderMapper;
    private Customer customer;

    @Before
    public void setUp() throws Exception {
         customer=new Customer();
    }

    @Test
    public void deleteByPrimaryKey() {
        //先删除客户（16） 对应的订单
       int n= orderMapper.deleteByPrimaryKey(10);
       if(n>0){
           iCustomerService.deleteByPrimaryKey(10);
       }
    }
    @Test
    public void load() {
        Order o=orderMapper.load(1);
        System.out.println(o);
    }

    @Test
    public void insert() {
       customer.setCustomerName("周生洪");
        int n= iCustomerService.insert(customer);
            Order order= new Order();
            order.setCid(customer.getCustomerId());
            order.setOrderNo("SAFD123");
            Order order1= new Order();
            order1.setCid(customer.getCustomerId());
            order1.setOrderNo("KIN12321");
            orderMapper.insert(order);
            orderMapper.insert(order1);
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByPrimaryKey() {
        Customer customer=iCustomerService.selectByPrimaryKey(4);
        System.out.println(customer);

    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }
    @Test
    public void CUSTOMER_LIST() {
      List<Customer> list=iCustomerService.CUSTOMER_LIST();
        for (Customer  c : list) {
            System.out.println(c);
        }
    }

}
