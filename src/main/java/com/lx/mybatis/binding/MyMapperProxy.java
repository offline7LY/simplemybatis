package com.lx.mybatis.binding;

import com.lx.mybatis.mapper.PersonMapperXml;
import com.lx.mybatis.session.MySqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 这个代理在mybatis中是为了调用查询语句的,是为了调用sqlsession的方法,
 * 客户调用的是selectByPrimaryKey实际后台是selectOne
 */
public class MyMapperProxy implements InvocationHandler {

    private final MySqlSession mySqlSession;
    private final String sql;

    public <T> MyMapperProxy(MySqlSession mySqlSession, String sql) {
        this.mySqlSession = mySqlSession;
        this.sql = sql;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

//        if (method.getDeclaringClass().getName().equals(PersonMapperXml.nameSpace)) {
//            String sql = PersonMapperXml.methodSqlMapping.get(method.getName());
//            return mySqlSession.selectOne(sql, String.valueOf(args[0]));
//        }
        return mySqlSession.selectOne(sql, String.valueOf(args[0]));
//        return method.invoke(proxy,args);
    }
}
