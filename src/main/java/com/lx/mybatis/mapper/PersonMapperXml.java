package com.lx.mybatis.mapper;

import java.util.HashMap;
import java.util.Map;

@Deprecated
public class PersonMapperXml {
    public static final String nameSpace = "com.lx.mybatis.mapper.PersonMapper";

    public static final Map<String, String> methodSqlMapping = new HashMap<>();

    static {
        methodSqlMapping.put("selectByPrimaryKey", "select * from t_person where id = ?");
    }
}
