package pers.boyuan.common.basic;

/**
 * 分页查询入参基础抽象类
 *
 * @author ZhangBoyuan
 * @date 2022-06-25
 */
public abstract class AbstractPageQuery {
    /**
     * 默认当前页
     */
    private static final Integer DEFAULT_PAGE_INDEX = 1;

    /**
     * 默认分页大小
     */
    private static final Integer DEFAULT_PAGE_SIZE = 10;

    /**
     * 升序
     */
    private static final String ASC = "ASC";

    /**
     * 降序
     */
    private static final String DESC = "DESC";

    /**
     * 当前页
     */
    private Integer pageIndex = DEFAULT_PAGE_INDEX;

    /**
     * 分页大小
     */
    private Integer pageSize = DEFAULT_PAGE_SIZE;

    /**
     * 排序方式
     */
    private String orderDirection = DESC;

    /**
     * 排序字段
     */
    private String orderByField;

    /**
     * 是否需要总条数，
     * 查询总条数会多查询一次，对于某些不需要总条数的场景，会造成性能上的浪费
     */
    private Boolean needTotalCount = Boolean.TRUE;

    public Integer getPageIndex() {
        if (this.pageIndex < 1) {
            pageIndex = DEFAULT_PAGE_INDEX;
        }
        return this.pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        if (pageIndex < 1) {
            pageIndex = DEFAULT_PAGE_INDEX;
        }
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        if (this.pageSize <= 0) {
            pageSize = DEFAULT_PAGE_SIZE;
        }
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize <= 0) {
            pageSize = DEFAULT_PAGE_SIZE;
        }
        this.pageSize = pageSize;
    }

    public String getOrderDirection() {
        if (ASC.equalsIgnoreCase(this.orderDirection) || DESC.equalsIgnoreCase(this.orderDirection)) {
            return orderDirection.toUpperCase();
        }
        return DESC;
    }

    public void setOrderDirection(String orderDirection) {
        if (ASC.equalsIgnoreCase(orderDirection) || DESC.equalsIgnoreCase(orderDirection)) {
            this.orderDirection = orderDirection.toUpperCase();
            return;
        }
        this.orderDirection = DESC;
    }

    public Boolean getNeedTotalCount() {
        return needTotalCount;
    }

    public void setNeedTotalCount(Boolean needTotalCount) {
        this.needTotalCount = needTotalCount;
    }

    public String getOrderByField() {
        return orderByField;
    }

    public void setOrderByField(String orderByField) {
        this.orderByField = orderByField;
    }

}
