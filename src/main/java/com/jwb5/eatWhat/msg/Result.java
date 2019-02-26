package com.jwb5.eatWhat.msg;

public class Result {
    private String msg;
    private int code;

    public static Result SUCCESS = new Result("success",0);

    public Result(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Result{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                '}';
    }
}
