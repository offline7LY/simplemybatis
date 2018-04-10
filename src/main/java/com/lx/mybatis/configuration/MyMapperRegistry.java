package com.lx.mybatis.configuration;

import com.lx.mybatis.annotation.MySelect;
import com.lx.mybatis.binding.MyMapperProxy;
import com.lx.mybatis.session.MySqlSession;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyMapperRegistry {

    private String sql;

    public <T> T getMapper(Class<T> type, MySqlSession sqlSession) {
        return (T) Proxy.newProxyInstance(type.getClassLoader(), new Class[]{type}, new MyMapperProxy(sqlSession, sql));
    }

    public MyMapperRegistry(){

    }

    public MyMapperRegistry(String path) {
        try {
            Class clazz = Class.forName(path);
            Method[] methods = clazz.getMethods();
            if (methods != null){
                for (Method method:methods){
                    Annotation[] annotations = method.getAnnotations();
                    MySelect select = null;
                    if(annotations != null){
                        for (Annotation annotation : annotations){
                            if (annotation instanceof MySelect){
                                select = (MySelect) annotation;
                                break;
                            }
                        }
                    }
                    if (select != null){
                        sql = select.value();
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
