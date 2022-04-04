/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.fastjrun.jeecgboot.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class PageResult<T> implements Serializable {
  public static final int PAGE_SIZE_DEFAULT = 20;
  private Integer total;
  private Integer size;
  private Integer pages;
  private Integer current;
  private Boolean  optimizeCountSql;
  private Boolean  searchCount;
  private List<String> orders;

  private List<T> records;

  public PageResult() {}

  public PageResult(List<T> records, Integer total, Integer size, Integer current) {
    this.records = records;
    this.total = total;
    this.size = size;
    this.current = current;
    this.pages = (int) Math.ceil((double) total / (double) size);
  }
}
