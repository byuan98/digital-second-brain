package pers.boyuan.api.in.bill;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import pers.boyuan.common.basic.AbstractPageQuery;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * 查询账单入参
 *
 * @author ZhangBoyuan
 * @date 2022-06-25
 */
@Data
@ApiModel("查询账单入参")
public class QueryBillPageAO extends AbstractPageQuery {
    /**
     * 主键id
     */
    @NotNull(message = "主键id不可为空")
    @ApiModelProperty("主键id")
    private Long id;

    /**
     * 账单类型
     */
    @ApiModelProperty("账单类型")
    private Integer type;

    /**
     * 账单分类id, 关联data_dictionary表id
     */
    @ApiModelProperty("账单分类id, 关联data_dictionary表id")
    private Integer categoryId;

    /**
     * 账单内容
     */
    @ApiModelProperty("账单内容")
    private String content;

    /**
     * 账单备注
     */
    @ApiModelProperty("账单备注")
    private String remark;

    /**
     * 账单金额: 单位(元)
     */
    @ApiModelProperty("账单金额: 单位(元)")
    private BigDecimal amount;

    /**
     * 最先付款时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty("最先付款时间")
    private String beginPaymentTime;

    /**
     * 最后付款时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty("最后付款时间")
    private String endPaymentTime;

}
