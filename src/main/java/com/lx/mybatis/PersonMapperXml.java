package com.lx.mybatis;

import java.util.HashMap;
import java.util.Map;

public class PersonMapperXml {
    public static final String nameSpace = "com.lx.mybatis.PersonMapper";

    public static final Map<String, String> methodSqlMapping = new HashMap<String, String>();

    static {
        methodSqlMapping.put("selectByPrimaryKey", "select * from t_person where id = ?");
    }
}
