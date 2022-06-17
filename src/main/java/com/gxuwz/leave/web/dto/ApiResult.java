package com.gxuwz.leave.web.dto;

/**
 * @author amu_1115@126.com
 * @version 1.0
 */
public class ApiResult {
    private String code;
    private String message;
    private Object data;

    public ApiResult(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ApiResult() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
