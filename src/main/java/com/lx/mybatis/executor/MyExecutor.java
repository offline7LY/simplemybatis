package com.lx.mybatis.executor;

import com.lx.mybatis.model.Person;
import com.lx.mybatis.resultset2object.MyResultSetHandler;
import com.lx.mybatis.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

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

            //result如何动态转换不用手动射
//            ResultSet resultSet = pStmt.executeQuery();
//            new MyResultSetHandler().handle(resultSet, person);
//            while (resultSet.next()){
//                person.setId(resultSet.getInt("id"));
//                person.setName(resultSet.getString("name"));
//            }
            new MyResultSetHandler().handle(pStmt, person);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //执行sql
        return (T) person;
    }
}
