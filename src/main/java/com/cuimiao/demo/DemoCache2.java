/*
 * Created by cuimiao on 2017/11/22.
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
 * @since 0.0.1 2017-11-22
 * 二级缓存demo.
 */
public class DemoCache2 {
  public static void main(String[] args) throws IOException {
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, "development_test");
    //SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession session = sqlSessionFactory.openSession();
    SqlSession session2 = sqlSessionFactory.openSession();
    try {
      BlogMapper mapper = session.getMapper(BlogMapper.class);
      Person person = mapper.getPersonById(1);
      session.close();//这个close必须要加，不然缓存存不进去。
      System.out.println();
      BlogMapper mapper2 = session2.getMapper(BlogMapper.class);
      Person person2 = mapper2.getPersonById(1);
      session2.close();
      System.out.println();
    } finally {
      session.close();
    }
  }
}