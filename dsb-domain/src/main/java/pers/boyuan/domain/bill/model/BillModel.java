package pers.boyuan.domain.bill.model;

import pers.boyuan.common.constants.DictionaryTypeConstant;
import pers.boyuan.common.enums.BaseEnum;
import pers.boyuan.common.util.CreateBeanUtil;
import pers.boyuan.domain.bill.enums.BillEnum;
import pers.boyuan.domain.dictionary.service.DictionaryDomainService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * 账单表领域层模型
 *
 * @author ZhangBoyuan
 * @date 2022-06-22
 */
public class BillModel {

    private DictionaryDomainService dictionaryDomainService = CreateBeanUtil.getBean(DictionaryDomainService.class);

    /**
     * 主键id
     */
    private Long id;

    /**
     * 账单类型: 1 -> 收入, -1 -> 支出
     */
    private Integer type;

    /**
     * 账单类型名称
     */
    private String typeName;

    /**
     * 账单分类id, 关联data_dictionary表
     */
    private Integer categoryId;

    /**
     * 账单分类名称
     */
    private String category;

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
     * 付款时间
     */
    private LocalDateTime paymentTime;

    /**
     * 最先付款时间
     */
    private String beginPaymentTime;

    /**
     * 最后付款时间
     */
    private String endPaymentTime;

    /**
     * 当前页
     */
    private Integer pageIndex;

    /**
     * 分页大小
     */
    private Integer pageSize;

    public BillModel() {
    }

    public DictionaryDomainService getDictionaryDomainService() {
        return dictionaryDomainService;
    }

    public void setDictionaryDomainService(DictionaryDomainService dictionaryDomainService) {
        this.dictionaryDomainService = CreateBeanUtil.getBean(DictionaryDomainService.class);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTypeName() {
        if (Objects.nonNull(this.type) && Objects.isNull(this.typeName)) {
            return BaseEnum.findByValue(BillEnum.BillTypeEnum.class, this.type).get().getText();
        }
        return this.typeName;
    }

    public void setTypeName(String typeName) {
        typeName = null;
        if (Objects.nonNull(this.type)) {
            typeName = BaseEnum.findByValue(BillEnum.BillTypeEnum.class, this.type).get().getText();
        }
        this.typeName = typeName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {
        if (Objects.nonNull(this.categoryId) && Objects.isNull(this.category)) {
            return dictionaryDomainService
                    .queryNameByTypeAndCode(DictionaryTypeConstant.BILL_CATEGORY, String.valueOf(this.categoryId));
        }
        return this.category;
    }

    public void setCategory(String category) {
        category = null;
        if (Objects.nonNull(this.categoryId)) {
            category = dictionaryDomainService
                    .queryNameByTypeAndCode(DictionaryTypeConstant.BILL_CATEGORY, String.valueOf(this.categoryId));
        }
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        if (Objects.nonNull(this.paymentTime)) {
            year = this.paymentTime.getYear();
        }
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        if (Objects.nonNull(this.paymentTime)) {
            month = this.paymentTime.getMonth().getValue();
        }
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        if (Objects.nonNull(this.paymentTime)) {
            day = this.paymentTime.getDayOfMonth();
        }
        this.day = day;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        if (Objects.nonNull(this.paymentTime)) {
            week = this.paymentTime.getDayOfWeek().getValue();
        }
        this.week = week;
    }

    public LocalDateTime getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(LocalDateTime paymentTime) {
        this.paymentTime = paymentTime;
        this.setYear(null);
        this.setMonth(null);
        this.setDay(null);
        this.setWeek(null);
    }

    public String getBeginPaymentTime() {
        return beginPaymentTime;
    }

    public void setBeginPaymentTime(String beginPaymentTime) {
        this.beginPaymentTime = beginPaymentTime;
    }

    public String getEndPaymentTime() {
        return endPaymentTime;
    }

    public void setEndPaymentTime(String endPaymentTime) {
        this.endPaymentTime = endPaymentTime;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
