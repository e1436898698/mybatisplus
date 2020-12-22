package com.liianjun.demo.common;


import com.liianjun.demo.enums.ResponseEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * @author lxl
 */
@Data
public class Response<T> implements Serializable {

    private static final long serialVersionUID = -4505655308965878999L;
    /** 返回数据 */
    private T data;
    /** 返回码 */
    private int code;
    /** 返回描述 */
    private String msg;
    /** 返回路径 */
    private String url;

    public Response() {
        this.code = ResponseEnum.SUCCESS.getCode();
        this.msg = ResponseEnum.SUCCESS.getMsg();
    }

    public Response(int code, String msg,String url) {
        this();
        this.code = code;
        this.msg = msg;
        this.url=url;
    }

    public Response(int code, String msg, T data,String url) {
        this();
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.url=url;
    }

    public Response(T data) {
        this();
        this.data = data;
    }

    public boolean success() {
        return 0 == this.code;
    }

    public boolean fail() {
        return 0 != this.code;
    }
}
