package pers.boyuan.domain.bill.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pers.boyuan.common.enums.BaseEnum;

/**
 * 账单表相关枚举
 *
 * @author ZhangBoyuan
 * @date 2022-06-25
 */
public class BillEnum {

    @Getter
    @AllArgsConstructor
    public enum BillTypeEnum implements BaseEnum {
        /**
         * -1 -> 支出
         */
        PAYMENT(-1, "支出"),

        /**
         * 1 -> 收入
         */
        INCOME(1, "收入"),
        ;

        private final Integer value;

        private final String text;

    }

}
