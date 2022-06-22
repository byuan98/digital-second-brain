package pers.boyuan.domain.bill.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 账单表领域层模型
 *
 * @author ZhangBoyuan
 * @date 2022-06-22
 */
@Data
public class BillModel {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 账单类型: 1 -> 收入, -1 -> 支出
     */
    private Integer type;

    /**
     * 账单分类id, 关联data_dictionary表
     */
    private Integer categoryId;

    /**
     * 账单内容
     */
    private String content;

    /**
     * 账单备注
     */
    private String remark;

    /**
     * 账单金额: 单位(元)
     */
    private BigDecimal amount;

    /**
     * 账单所属年份yyyy
     */
    private Integer year;

    /**
     * 账单所属月份: 1~12
     */
    private Integer month;

    /**
     * 账单所属日: 1~31
     */
    private Integer day;

    /**
     * 账单所属星期: 1~7
     */
    private Integer week;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtUpdate;

}
