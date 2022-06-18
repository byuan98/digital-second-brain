package pers.boyuan.common.dto;

import lombok.Data;
import pers.boyuan.common.constants.ResponseEnum;

/**
 * @author ZhangBoyuan
 * @date 2022-06-11
 */
@Data
public class Response<T> {
    private Integer code;
    private String message;
    private T data;

    public Response() {
    }

    public Response(Integer code, String msg) {
        this(code, msg, null);
    }

    public Response(Integer code, String msg, T data) {
        this.code = code;
        this.data = data;
        this.message = msg;
    }

    public static Response response(ResponseEnum responseEnum) {
        return new Response(responseEnum.getCode(), responseEnum.getMessage());
    }

    public static Response response(ResponseEnum responseEnum, Object obj) {
        return new Response(responseEnum.getCode(), responseEnum.getMessage(), obj);
    }

    public static Response success() {
        return new Response(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMessage());
    }

    public static Response success(String message) {
        return new Response(ResponseEnum.SUCCESS.getCode(), message);
    }

    public static <T> Response<T> success(T data) {
        Response<T> response = new Response();
        response.setCode(ResponseEnum.SUCCESS.getCode());
        response.setMessage(ResponseEnum.SUCCESS.getMessage());
        response.setData(data);
        return response;
    }

    public static Response error(ResponseEnum responseEnum) {
        return new Response(responseEnum.getCode(), responseEnum.getMessage());
    }

    public static Response error(Integer code, String msg) {
        return new Response(code, msg);
    }

    public static Response build(ResponseEnum responseEnum) {
        return new Response(responseEnum.getCode(), responseEnum.getMessage());
    }

}
