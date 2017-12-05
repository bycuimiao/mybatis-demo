/*
 * Created by cuimiao on 2017/11/21.
 */

package com.cuimiao.mappers;

import com.cuimiao.entity.Person;

import java.util.List;

/**
 * @author cuimiao
 * @version 0.0.1
 * @since 0.0.1 2017-11-21
 */
public interface BlogMapper {
  Person getPersonById(int id);
  Person getPerson();

  void updataPersonBatch(List<Person> persons);
}