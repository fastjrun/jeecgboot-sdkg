/*
 * Copyright (C) 2019 fastjrun, Inc. All Rights Reserved.
 */
package com.fastjrun.jeecgboot.common;

/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
public interface CodeMsgI {

    Integer CODE_OK = 0;

    String CODE_OK_MSG = "OK";

    Integer getCode();

    String getMsg();
}
