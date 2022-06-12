package pers.boyuan.common.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author ZhangBoyuan
 * @date 2022-06-11
 */
@Getter
@AllArgsConstructor
public enum ResponseEnum {

    /**
     * 0 -> 操作成功
     */
    SUCCESS(0, "操作成功"),
    /**
     * 1 -> 操作失败, 请稍后重试
     */
    FAIL(1, "操作失败，请稍后重试"),
    ;

    private Integer code;

    private String message;
}
