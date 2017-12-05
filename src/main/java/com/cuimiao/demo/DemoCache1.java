/*
 * Created by cuimiao on 2017/11/21.
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

/**
 * @author cuimiao
 * @version 0.0.1
 * @since 0.0.1 2017-11-21
 * 一级缓存demo.
 */
public class DemoCache1 {
  public static void main(String[] args) throws IOException {
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, "development_test");
    //SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession session = sqlSessionFactory.openSession();
    try {
      BlogMapper mapper = session.getMapper(BlogMapper.class);
      Person person = mapper.getPerson();
      System.out.println();
      Person person2 = mapper.getPerson();
      System.out.println();
    } finally {
      session.close();
    }
  }
}