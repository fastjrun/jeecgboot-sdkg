package com.fastjrun.jeecgboot.helper;


import com.fastjrun.jeecgboot.common.CodeMsgI;
import com.fastjrun.jeecgboot.vo.PageResult;
import com.fastjrun.jeecgboot.vo.ResultListModel;
import com.fastjrun.jeecgboot.vo.ResultModel;
import com.fastjrun.jeecgboot.vo.ResultPageModel;

import java.util.List;

public class ResultHelper {

    public static <T> ResultModel<T> ok() {
        return new ResultModel(Boolean.TRUE,CodeMsgI.CODE_OK, CodeMsgI.CODE_OK_MSG);
    }

    public static <T> ResultModel<T> ok(T result) {
        return new ResultModel(Boolean.TRUE,CodeMsgI.CODE_OK, CodeMsgI.CODE_OK_MSG, result);
    }

    public static <T> ResultModel<T> fail(CodeMsgI codeMsgI) {
        return result(Boolean.FALSE,codeMsgI);
    }

    public static <T> ResultModel<T> result(Boolean success,CodeMsgI codeMsgI) {
        return result(success,codeMsgI, null);
    }

    public static <T> ResultModel<T> result(Boolean success,CodeMsgI codeMsgI, T result) {
        return new ResultModel(success,codeMsgI.getCode(), codeMsgI.getMsg(), result);
    }

    public static <T> ResultModel<T> fail(Integer code, String msg) {
        return new ResultModel(Boolean.FALSE,code, msg);
    }

    public static <T> ResultListModel<T> okList() {

        return new ResultListModel(Boolean.TRUE,CodeMsgI.CODE_OK, CodeMsgI.CODE_OK_MSG);
    }

    public static <T> ResultListModel<T> okList(List<T> result) {
        return new ResultListModel(Boolean.TRUE,CodeMsgI.CODE_OK, CodeMsgI.CODE_OK_MSG, result);
    }

    public static <T> ResultListModel<T> failList(CodeMsgI code) {
        return resultList(Boolean.FALSE,code);
    }

    public static <T> ResultListModel<T> resultList(Boolean success,CodeMsgI code) {
        return resultList(success,code, null);
    }

    public static <T> ResultListModel<T> resultList(Boolean success,CodeMsgI codeMsgI, List<T> result) {
        return new ResultListModel(success,codeMsgI.getCode(), codeMsgI.getMsg(), result);
    }

    public static <T> ResultListModel<T> failList(Integer code, String msg) {
        return new ResultListModel(Boolean.FALSE,code, msg);
    }

    public static <T> ResultPageModel<T> okPage() {
        return new ResultPageModel(Boolean.TRUE,CodeMsgI.CODE_OK, CodeMsgI.CODE_OK_MSG);
    }

    public static <T> ResultPageModel<T> okPage(PageResult<T> result) {
        return new ResultPageModel(Boolean.TRUE,CodeMsgI.CODE_OK, CodeMsgI.CODE_OK_MSG, result);
    }

    public static <T> ResultPageModel<T> failPage(CodeMsgI codeMsgI) {
        return resultPage(Boolean.FALSE,codeMsgI);
    }

    public static <T> ResultPageModel<T> resultPage(Boolean success,CodeMsgI codeMsgI) {
        return resultPage(success,codeMsgI, null);
    }

    public static <T> ResultPageModel<T> resultPage(Boolean success,CodeMsgI codeMsgI, PageResult<T> result) {
        return new ResultPageModel(success,codeMsgI.getCode(), codeMsgI.getMsg(), result);
    }

    public static <T> ResultPageModel<T> failPage(Integer code, String msg) {
        return new ResultPageModel(Boolean.FALSE,code, msg);
    }
}
