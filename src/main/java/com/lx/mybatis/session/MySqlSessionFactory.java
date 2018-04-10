package com.lx.mybatis.session;

import com.lx.mybatis.configuration.MyConfiguration;

public class MySqlSessionFactory {
    public  MySqlSession build(String xmlPath){
        //注解操作， 传入包名加接口名
        return new MySqlSession(new MyConfiguration("com.lx.mybatis.mapper.PersonMapper"));
    }
}
