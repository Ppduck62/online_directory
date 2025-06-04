package com.onlineaddressbooksystem.common;

import lombok.Data;

@Data
public class Result<T> {
    private Integer code;
    private String msg;
    private T data;

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(1);
        result.setMsg("success");
        result.setData(data);
        return result;
    }

    public static Result<Void> success() {
        Result<Void> result = new Result<>();
        result.setCode(1);
        result.setMsg("success");
        return result;
    }

    public static Result<Void> success(String msg) {
        Result<Void> result = new Result<>();
        result.setCode(1);
        result.setMsg(msg);
        return result;
    }

    public static Result<Void> error(String msg) {
        Result<Void> result = new Result<>();
        result.setCode(0);
        result.setMsg(msg);
        return result;
    }
}
