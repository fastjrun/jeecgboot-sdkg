package com.fastjrun.jeecgboot.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class PageQuery implements Serializable {
  /** 当前页 */
  private Integer pageNo;
  /** 每页条数 */
  private Integer pageSize;

  private static final long serialVersionUID = -2646524565649755149L;
}
