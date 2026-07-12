package com.mall.common.api;

import java.util.List;

public record CommonPage<T>(
        Integer pageNum,
        Integer pageSize,
        Integer totalPage,
        Long total,
        List<T> list
) {

    public static <T> CommonPage<T> restPage(List<T> list, Long total, Integer pageNum, Integer pageSize) {
        int totalPage = pageSize == 0 ? 0 : (int) Math.ceil((double) total / pageSize);
        return new CommonPage<>(pageNum, pageSize, totalPage, total, list);
    }
}