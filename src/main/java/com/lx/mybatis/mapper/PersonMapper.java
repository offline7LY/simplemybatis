package com.lx.mybatis.mapper;

import com.lx.mybatis.annotation.MySelect;
import com.lx.mybatis.model.Person;

public interface PersonMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Person record);

    int insertSelective(Person record);

    @MySelect(value = "select * from t_person where id = ?")
    Person selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Person record);

    int updateByPrimaryKey(Person record);
}