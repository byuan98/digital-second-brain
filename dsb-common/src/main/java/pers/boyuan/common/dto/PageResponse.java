package pers.boyuan.common.dto;

import pers.boyuan.common.constants.ResponseEnum;

import java.util.*;

/**
 * @author ZhangBoyuan
 * @date 2022-06-25
 */
public class PageResponse<T> extends Response {
    /**
     * 总页数
     */
    private Long totalCount = 0L;

    /**
     * 当前页
     */
    private Long pageIndex = 1L;

    /**
     * 当前页大小
     */
    private Long pageSize = 1L;

    /**
     * 数据
     */
    private Collection<T> data;

    public Long getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public Long getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Long pageIndex) {
        this.pageIndex = pageIndex;
    }

    @Override
    public List<T> getData() {
        if (Objects.isNull(this.data)) {
            return Collections.emptyList();
        }
        return new ArrayList<>(data);
    }

    public void setData(Collection<T> data) {
        this.data = data;
    }

    public static PageResponse error(ResponseEnum responseEnum) {
        PageResponse pageResponse = new PageResponse<>();
        pageResponse.setSuccess(Boolean.FALSE);
        pageResponse.setCode(responseEnum.getCode());
        pageResponse.setMessage(responseEnum.getMessage());
        return pageResponse;
    }

    public static PageResponse error(Integer errorCode, String errorMessage) {
        PageResponse pageResponse = new PageResponse();
        pageResponse.setSuccess(Boolean.FALSE);
        pageResponse.setCode(errorCode);
        pageResponse.setMessage(errorMessage);

        return pageResponse;
    }

    public static <T> PageResponse<T> success(Long totalCount, Long pageIndex, Long pageSize, Collection<T> data) {
        PageResponse<T> pageResponse = new PageResponse<>();
        pageResponse.setSuccess(Boolean.TRUE);
        pageResponse.setTotalCount(totalCount);
        pageResponse.setPageIndex(pageIndex);
        pageResponse.setPageSize(pageSize);
        pageResponse.setData(data);

        return pageResponse;
    }

}
