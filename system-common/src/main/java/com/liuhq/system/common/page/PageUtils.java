package com.liuhq.system.common.page;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;

/**
 * 分页工具类
 */
public class PageUtils<T> {

	/**
	 * 分页
	 */
	public static <T, E> Page<T> page(PageInfo<E> pageInfo) {
		return Page.<T>builder().pageNum(pageInfo.getPageNum()).pageSize(pageInfo.getPageSize())
				.size(pageInfo.getSize()).startRow(pageInfo.getStartRow()).endRow(pageInfo.getEndRow())
				.total(pageInfo.getTotal()).pages(pageInfo.getPages())
				.list(Lists.<E, T>transform(pageInfo.getList(), obj -> {
					return JSON.parseObject(JSON.toJSONString(obj), new TypeReference<T>() {
					});
				})).isFirstPage(pageInfo.isIsFirstPage()).isLastPage(pageInfo.isIsLastPage())
				.hasPreviousPage(pageInfo.isHasPreviousPage()).hasNextPage(pageInfo.isHasNextPage())
				.navigatePages(pageInfo.getNavigatePages()).navigatepageNums(pageInfo.getNavigatepageNums())
				.prePage(pageInfo.getPrePage()).nextPage(pageInfo.getNextPage())
				.navigateFirstPage(pageInfo.getNavigateFirstPage()).navigateLastPage(pageInfo.getNavigateLastPage())
				.build();
	}

}
