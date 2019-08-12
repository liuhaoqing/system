package com.liuhq.system.common.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * 返回结果实体类
 */
@Data
@Builder
@ApiModel(value = "接口返回对象")
public class ApiResult<T> {

	/** 返回状态码 **/
	@ApiModelProperty(value = "返回状态码")
	private int code;

	/** 返回消息 **/
	@ApiModelProperty(value = "返回信息")
	private String message;

	/** 返回数据 **/
	@ApiModelProperty(value = "返回数据")
	private T data;

}
