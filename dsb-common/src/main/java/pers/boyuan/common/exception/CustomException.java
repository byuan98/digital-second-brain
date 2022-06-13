package pers.boyuan.common.exception;

import pers.boyuan.common.constants.ResponseEnum;

/**
 * 自定义异常类
 *
 * @author ZhangBoyuan
 * @date 2022-06-13
 */
public class CustomException extends RuntimeException {

    private Integer code;

    private String message;


    public CustomException(ResponseEnum responseEnum) {
        super(responseEnum.getMessage());
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
    }

    public CustomException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
