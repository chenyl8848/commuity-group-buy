package com.cyl.groupbuy.framework.result;

import lombok.Getter;

/**
 * @author：Java陈序员
 * @date：2023/9/11 16:10
 * @description：统一返回状态信息枚举类
 */
@Getter
public enum ResultCodeEnum {

    SUCCESS(200, "成功"),
    FAIL(500, "失败"),
    ;

    /**
     * 返回码
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
