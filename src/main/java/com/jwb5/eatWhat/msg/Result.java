package com.jwb5.eatWhat.msg;

public class Result<T> {
    private boolean isSuccess = true;
    private String msg;
    private int code;
    private T data;

    private Result() {
    }

    private Result(T data) {
        this.data = data;
    }

    private Result(boolean isSuccess, int code, String msg) {
        this.isSuccess = isSuccess;
        this.msg = msg;
        this.code = code;
    }

    private Result(boolean isSuccess, int code, String msg, T data) {
        this.isSuccess = isSuccess;
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public static Result success(){
        return new Result();
    }

    public static <T> Result success(T data){
        return new Result(data);
    }
    public static <T> Result error(int code, String msg,T data){
        return new Result(false,code,msg,data);
    }
    public static <T> Result error(int code, String msg){
        return new Result(false,code,msg);
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    public T getData() {
        return data;
    }
}
