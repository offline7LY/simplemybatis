package com.lx.mybatis;

public interface Executor {
    <T> T query(String statement, Object parameter);
}
