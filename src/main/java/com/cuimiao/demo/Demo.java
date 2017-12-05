/*
 * Created by cuimiao on 2017/11/23.
 */

package com.cuimiao.demo;

import com.cuimiao.entity.Person;
import com.cuimiao.mappers.BlogMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cuimiao
 * @version 0.0.1
 * @Description:demo.
 * @since 0.0.1 2017-11-23
 */
public class Demo {
  public static void main(String[] args) throws IOException {
    String resource = "mybatis-config.xml";
    //获取配置文件流的源码完全看不懂。。。
    InputStream inputStream = Resources.getResourceAsStream(resource);
    //获取sqlSessionFactory的源码，完全看不懂。。。
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, "development_test");
    //SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    //获取SqlSession
    SqlSession session = sqlSessionFactory.openSession();
    try {
      BlogMapper mapper = session.getMapper(BlogMapper.class);
      //Person person = mapper.getPersonById(1);
      List<Person> persons = new ArrayList<Person>();
      Person person = new Person();
      person.setUserId(2L);
      person.setName("haahh");
      persons.add(person);
      mapper.updataPersonBatch(persons);
      session.commit();
      System.out.println();
    } finally {
      session.close();
    }
  }
}