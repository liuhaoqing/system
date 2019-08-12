package com.liuhq.system.common.page;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ApiModel("分页参数")
public class Page<T> {

	@ApiModelProperty(value = "当前页")
	private int pageNum;

	@ApiModelProperty(value = "每页的数量")
	private int pageSize;

	@ApiModelProperty(value = "当前页的数量")
	private int size;

	@ApiModelProperty(value = "当前页面第一个元素在数据库中的行号")
	private int startRow;

	@ApiModelProperty(value = "当前页面最后一个元素在数据库中的行号")
	private int endRow;

	@ApiModelProperty(value = "总记录数")
	protected long total;

	@ApiModelProperty(value = "总页数")
	private int pages;

	@ApiModelProperty(value = "结果集")
	protected List<T> list;

	@ApiModelProperty(value = "是否为第一页")
	private boolean isFirstPage;

	@ApiModelProperty(value = "是否为最后一页")
	private boolean isLastPage;

	@ApiModelProperty(value = "是否有前一页")
	private boolean hasPreviousPage;

	@ApiModelProperty(value = "是否有下一页")
	private boolean hasNextPage;

	@ApiModelProperty(value = "导航页码数")
	private int navigatePages;

	@ApiModelProperty(value = "所有导航页号")
	private int[] navigatepageNums;

	@ApiModelProperty(value = "前一页页码")
	private int prePage;

	@ApiModelProperty(value = "下一页页码")
	private int nextPage;

	@ApiModelProperty(value = "导航条上的第一页")
	private int navigateFirstPage;

	@ApiModelProperty(value = "导航条上的最后一页")
	private int navigateLastPage;

}
