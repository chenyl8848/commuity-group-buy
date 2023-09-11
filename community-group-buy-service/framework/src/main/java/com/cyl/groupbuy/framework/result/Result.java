package com.cyl.groupbuy.framework.result;

import lombok.Data;

/**
 * @author：Java陈序员
 * @date：2023/9/11 16:05
 * @description：统一返回实体类
 */
@Data
public class Result<T> {

    /**
     * 返回码
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;

    public static <T> Result<T> build(Integer code, String message, T data) {
        Result<T> result = new Result<>();

        result.setCode(code);
        result.setMessage(message);
        result.setData(data);

        return result;
    }

    public static <T> Result<T> build(ResultCodeEnum resultCodeEnum, T data) {
        return build(resultCodeEnum.getCode(), resultCodeEnum.getMessage(), data);
    }

    public static <T> Result<T> success(T data) {
        return build(ResultCodeEnum.SUCCESS, data);
    }

    public static <T> Result<T> fail(T data) {
        return build(ResultCodeEnum.FAIL, data);
    }
}
