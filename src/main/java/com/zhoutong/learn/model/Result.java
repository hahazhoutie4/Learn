package com.zhoutong.learn.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {
    private final static Integer errorCode = 0;
    private final static Integer okCode = 1;
    private final static String okmsg = "返回成功";
    private final static String errormsg = "返回失败";
    private  Object data;
    private  Integer code;
    private  String msg;

    public Result() {
    }

    public Object getObject() {
        return data;
    }

    public void setObject(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Result(Object data, Integer code, String msg){
        this.data = data;
        this.code = code;
        this.msg = msg;
    }
    public static Result okResult(Object data) {
        return new Result(data, Result.okCode, Result.okmsg);
    }

    public static Result errorResult(Object data) {
        return new Result(data, Result.errorCode, Result.errormsg);
    }

    @Override
    public String toString() {
        return "Result{" +
                "data=" + data +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
