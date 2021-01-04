package com.zking.ssm.mapper;

import com.sun.corba.se.spi.oa.OADefault;
import com.zking.ssm.model.Order;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class OrderMapperTest {
    private Order order;

    @Before
    public void setUp() throws Exception {
        order = new Order();
    }

}
