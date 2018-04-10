package com.lx.mybatis.executor;

import java.util.HashMap;
import java.util.Map;

public class MyCacheExecutor implements Executor{

    private Map<String,Object> localCache = new HashMap();
    private MyExecutor delegate = new MyExecutor();
    /**
     * CacheExecutor与普通Executor相比就是在查询前先读缓存
     * @param sql
     * @param parameter
     * @param <T>
     * @return
     */
    @Override
    public <T> T query(String sql, Object parameter) {
        //todo 这里直接用sql做key有问题, sql每次相同， 我只换id怎么办
        if(localCache.get(sql) != null){
            System.out.println("从缓存中读取: key:" + sql);
            return (T) localCache.get(sql);
        }
        T result = delegate.query(sql, parameter);
        localCache.put(sql, result);
        return result;
    }
}
