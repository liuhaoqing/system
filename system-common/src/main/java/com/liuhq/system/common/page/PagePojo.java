package com.liuhq.system.common.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 分页条件
 */
@Getter
@Setter
@ApiModel("分页条件")
public class PagePojo {

	/** 每页数量，默认为10 **/
	@ApiModelProperty(value = "页数", example = "1", required = false)
	private Integer pageNum = 1;

	/** 页数 **/
	@ApiModelProperty(value = "每页数量", example = "10", required = false)
	private Integer pageSize = 10;

}
