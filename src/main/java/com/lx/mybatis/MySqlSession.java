package com.lx.mybatis;

import java.lang.reflect.Proxy;

public class MySqlSession {
    public <T>T getMapper(Class<T> mapperClass) {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{mapperClass}, new MyMapperProxy(this, mapperClass));    }

    /**
     * 跟数据库接触的对象
     */
    private Executor executor = new MyExecutor();

    public <T> T selectOne(String sql, Object args) {
        return executor.query(sql,args);
    }

}
