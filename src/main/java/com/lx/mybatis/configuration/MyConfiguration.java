package com.lx.mybatis.configuration;

import com.lx.mybatis.session.MySqlSession;

public class MyConfiguration {

    /**
     *
     */
    protected final MyMapperRegistry myMapperRegistry;

    public MyConfiguration() {
        //mapperreg
        this.myMapperRegistry = new MyMapperRegistry();
    }

    public MyConfiguration(String clazz) {
        //mapperreg
        this.myMapperRegistry = new MyMapperRegistry(clazz);
    }

    public <T> T getMapper(Class<T> type, MySqlSession sqlSession) {
        return this.myMapperRegistry.getMapper(type, sqlSession);
    }
}
