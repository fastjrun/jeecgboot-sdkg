/*
 * Copyright (C) 2019 fastjrun, Inc. All Rights Reserved.
 */
package com.fastjrun.jeecgboot.client.common;
import com.fastjrun.jeecgboot.common.BaseException;
import com.fastjrun.jeecgboot.common.CodeMsgI;


/**
 * @author fastjrun
 * 响应码和响应消息封装类
 */
public class ClientException extends BaseException {


    private static final long serialVersionUID = -2959355115773679964L;

    public ClientException(Integer code, String msg) {
        super(code,msg);
    }

    public ClientException(CodeMsgI codeMsgI) {
        super(codeMsgI.getCode(), codeMsgI.getMsg());
    }
}