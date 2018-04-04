package com.lx.mybatis.executor;

public interface Executor {
    <T> T query(String statement, Object parameter);
}
