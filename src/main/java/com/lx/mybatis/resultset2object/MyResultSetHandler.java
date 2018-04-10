package com.lx.mybatis.resultset2object;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyResultSetHandler {
    /**
     * 该方法约定 set方法就是 set + 属性首字母大写
     * @param pstmt
     * @param t
     * @param <E>
     * @return
     * @throws SQLException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public <E> void handle(PreparedStatement pstmt, E t) throws SQLException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            int i = 0;
            for (Field field : t.getClass().getDeclaredFields()) {
                setValue(t, field, rs, i);
            }
        }
    }

    /**
     *  根据遍历到的每个属性动态访问set方法，约定set方法命名
     */
    private void setValue(Object resultObj, Field field, ResultSet rs, int i) throws NoSuchMethodException, SQLException, InvocationTargetException, IllegalAccessException {
        Method setMethod = resultObj.getClass().getMethod("set" + upperCapital(field.getName()), field.getType());
        setMethod.invoke(resultObj, rs.getObject(field.getName()));
//        setMethod.invoke(resultObj, getResult(field, rs));
    }

    /**
     * 根据字段类型调用rs的不同方法
     * //todo 如何反射实现动态调用getWhat()
     * @param field
     * @param rs
     * @return
     * @throws SQLException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    private Object getResult(Field field, ResultSet rs) throws SQLException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> type = field.getType();
        if (Integer.class == type) {
            return rs.getInt(field.getName());
        }else if (String.class == type) {
            return rs.getString(field.getName());
        }
        return rs.getString(field.getName());

//        Type type = field.getGenericType();
//        String[] split = type.toString().split(".");
//        System.out.println(split);
//        String methodName = "get" + upperCapital(split[split.length - 1]);
//        Method method = rs.getClass().getMethod(methodName);
//        return method.invoke(rs, field.getName());
    }

    private String upperCapital(String name) {
        char[] ch = name.toCharArray();
        if (ch[0] >= 'a' && ch[0] <= 'z') {
            ch[0] = (char) (ch[0] - 32);
        }
        return new String(ch);
    }
}
