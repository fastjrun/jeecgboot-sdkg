/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.fastjrun.jeecgboot.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ResultPageModel<T> extends BaseResultModel implements Serializable {

    private static final long serialVersionUID = -4710875926501827304L;

    private PageResult<T> result;


    public ResultPageModel(Boolean success, Integer code, String message) {
        this(success, code, message, null);
    }

    public ResultPageModel(Boolean success, Integer code, String message, PageResult<T> result) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.result = result;
        this.timestamp = System.currentTimeMillis();
    }
}
