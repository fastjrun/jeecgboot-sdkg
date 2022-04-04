/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.fastjrun.jeecgboot.vo;

import lombok.Data;

@Data
public abstract class BaseResultModel {
  protected Boolean success;

  protected Integer code;

  protected String message = "";

  protected Long timestamp;
}
