package com.lx.mybatis;

import com.lx.mybatis.mapper.PersonMapper;
import com.lx.mybatis.model.Person;
import com.lx.mybatis.session.MySqlSession;

public class TestSimpleMybatis {

    @org.junit.Test
    public void testSimpleMybatis(){
        MySqlSession sqlSession = new MySqlSession();
        PersonMapper testMapper = sqlSession.getMapper(PersonMapper.class);
        Person test = testMapper.selectByPrimaryKey(1);
        System.out.println(test.getId());
        System.out.println(test.getName());
    }
}