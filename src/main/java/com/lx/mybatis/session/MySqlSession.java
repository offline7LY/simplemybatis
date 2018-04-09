package com.lx.mybatis.session;

import com.lx.mybatis.configuration.MyConfiguration;
import com.lx.mybatis.executor.Executor;
import com.lx.mybatis.executor.MyCacheExecutor;

public class MySqlSession {
    private final MyConfiguration myConfiguration ;

    public MySqlSession(MyConfiguration myConfiguration) {
        this.myConfiguration = myConfiguration;
    }

    public <T>T getMapper(Class<T> type) {
        //后面代理类实现需要sqlsession, 所以当前session会一直传递
        return this.myConfiguration.getMapper(type, this);
    }

    /**
     * 跟数据库接触的对象
     */
    private final Executor executor = new MyCacheExecutor();

    public <T> T selectOne(String sql, Object args) {
        return executor.query(sql,args);
    }

}
