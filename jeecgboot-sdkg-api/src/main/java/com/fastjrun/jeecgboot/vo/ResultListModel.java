/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.fastjrun.jeecgboot.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ResultListModel<T> extends BaseResultModel implements Serializable {

    private static final long serialVersionUID = -4710875926501827304L;

    private List<T> result;

    public ResultListModel(Boolean success, Integer code, String message) {
        this(success, code, message, null);
    }

    public ResultListModel(Boolean success, Integer code, String message, List<T> result) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.result = result;
        this.timestamp = System.currentTimeMillis();
    }
}
