/*
 * Copyright (C) 2019 fastjrun, Inc. All Rights Reserved.
 */
package com.fastjrun.jeecgboot.service.common;


import com.fastjrun.jeecgboot.common.BaseException;
import com.fastjrun.jeecgboot.common.CodeMsgI;

public class ServiceException extends BaseException {

    private static final long serialVersionUID = 1511421458976623065L;

    public ServiceException(Integer code, String msg) {
        super(code, msg);
    }


    public ServiceException(CodeMsgI codeMsgI) {
        super(codeMsgI.getCode(), codeMsgI.getMsg());
    }
}