package com.zhoutong.learn.model;

public class ResultImpl implements Result {
    private  Object object;
    private  Integer code;
    private  String msg;

    public ResultImpl() {
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
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

    public ResultImpl(Object object, Integer code, String msg){
        this.object = object;
        this.code = code;
        this.msg = msg;
    }
    public static Result okResult(Object o) {
        return new ResultImpl(o, Result.okCode, Result.okmsg);
    }

    public static Result errorResult(Object o) {
        return new ResultImpl(o, Result.errorCode, Result.errormsg);
    }

    @Override
    public String toString() {
        return "ResultImpl{" +
                "object=" + object +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
