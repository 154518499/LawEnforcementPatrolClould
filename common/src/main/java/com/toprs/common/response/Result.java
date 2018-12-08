package com.toprs.common.response;

/**
 * 返回结果的封装
 * @param <T>
 */
public class Result<T> {
    /*状态码*/
    private Integer code;
    /*提示信息*/
    private String reason;;
    /*具体的内容*/
    private T result;;

    public Result() {
    }

    public Result(Integer code, String reason, T result) {
        this.code = code;
        this.reason = reason;
        this.result = result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }
}
