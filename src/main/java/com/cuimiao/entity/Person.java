/*
 * Created by cuimiao on 2017/11/21.
 */

package com.cuimiao.entity;

/**
 * @author cuimiao
 * @version 0.0.1
 * @since 0.0.1 2017-11-21
 */
public class Person {
  private Long id;
  private Long userId;
  private String name;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}