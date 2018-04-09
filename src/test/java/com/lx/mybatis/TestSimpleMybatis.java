package com.lx.mybatis;

import com.lx.mybatis.mapper.PersonMapper;
import com.lx.mybatis.model.Person;
import com.lx.mybatis.session.MySqlSession;
import com.lx.mybatis.session.MySqlSessionFactory;

public class TestSimpleMybatis {

    @org.junit.Test
    public void testSimpleMybatis(){
        MySqlSession sqlSession = new MySqlSessionFactory().build("xxxconfig.xml");
        PersonMapper testMapper = sqlSession.getMapper(PersonMapper.class);

        //先读取一次， 以后就会从缓存里获取
        testMapper.selectByPrimaryKey(1);

        //从缓存里取
        Person test = testMapper.selectByPrimaryKey(1);
        System.out.println(test.getId());
        System.out.println(test.getName());

    }
}