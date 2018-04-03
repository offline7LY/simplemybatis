package com.lx.mybatis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 真正跟数据库打交道的类
 */
public class MyExecutor implements Executor{

    /**
     *
     * @param sql
     * @param parameter
     * @param <T>
     * @return
     */
    public <T> T query(String sql, Object parameter) {

        //结果集转对象
        Person person = new Person();

        try {
            //获取数据库连接
            Connection conn = DBUtil.getConn();
            PreparedStatement pStmt = DBUtil.getPStmt(conn, sql);
            pStmt.setInt(1, Integer.parseInt(String.valueOf(parameter)));
            ResultSet resultSet = pStmt.executeQuery();

            while (resultSet.next()){
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
            }
        } catch (SQLException e) {

        }

        //执行sql
        return (T) person;
    }
}
