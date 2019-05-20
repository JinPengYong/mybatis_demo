package com.cheer.mybatis.dao;

import com.cheer.mybatis.model.Emp;

import java.util.List;

public interface EmpMapper {
    Emp getEmp(Integer empNo);
    List<Emp> getList();
}
