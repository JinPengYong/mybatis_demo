package com.cheer.mybatis.dao;


import com.cheer.mybatis.model.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class EmpMapperTest {

    private static final Logger LOGGER = LogManager.getLogger(EmpMapperTest.class);

    @Test
    public void getEmp(){
        InputStream in=null;
        try {
            in= Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 创建一个SqlSessionFactory对象
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
        // 打开一个会话
        SqlSession session=factory.openSession();
        // 获取EmpMapper对象
        EmpMapper empMapper=session.getMapper(EmpMapper.class);

        // 查询emp
        Emp emp=empMapper.getEmp(7788);
        LOGGER.error(emp);
        if (in!=null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void getList(){
        InputStream in=null;
        try {
            in=Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }

        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
        SqlSession session=factory.openSession();
        EmpMapper empMapper=session.getMapper(EmpMapper.class);
        List<Emp> list=empMapper.getList();

        LOGGER.info(list);
        if (in!=null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



