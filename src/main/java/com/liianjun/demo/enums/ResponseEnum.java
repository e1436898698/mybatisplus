package com.liianjun.demo.enums;



import lombok.extern.slf4j.Slf4j;

/**
 * @author lxl
 */
@Slf4j
public enum ResponseEnum {
    /* ######### 基本返回码 ######### */
    /** 请求处理成功 */
    SUCCESS(0, "ok"),
    /** token异常 */
    AUTHORITY(-1, ""),
    /** 未知异常 */
    UNKNOWN(99999, "未知异常"),

    /* ######### 系统返回码 ######### */

    ;

    int code;
    String msg;
    String hints;

    ResponseEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static ResponseEnum getEnum(int code) {
        for (ResponseEnum ele : values()) {
            if (ele.getCode() == code) {
                return ele;
            }
        }
        log.error("-----> 枚举code:{}不存在", code);
        return ResponseEnum.UNKNOWN;
    }
}
