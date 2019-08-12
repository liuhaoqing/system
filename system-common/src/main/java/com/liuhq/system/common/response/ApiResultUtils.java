package com.liuhq.system.common.response;

import com.liuhq.system.common.exception.BaseException;

/**
 * 返回结果工具类
 */
public class ApiResultUtils<T> {

	/**
	 * 返回成功，一般用于更新/删除/插入操作后无需返回结果时使用
	 */
	public static <T> ApiResult<T> success() {
		return success(null);
	}

	/**
	 * 返回成功，一般用于查询操作后无需返回结果时使用
	 */
	public static <T> ApiResult<T> success(T data) {
		return ApiResult.<T>builder().code(ApiResultEnum.SUCCESS.getCode()).message(ApiResultEnum.SUCCESS.getMessage())
				.data(data).build();
	}

	public static ApiResult<String> failure() {
		return ApiResult.<String>builder().code(ApiResultEnum.UNKNOWN.getCode())
				.message(ApiResultEnum.UNKNOWN.getMessage()).build();
	}

	public static ApiResult<String> failure(BaseException e) {
		return ApiResult.<String>builder().code(ApiResultEnum.FAILURE.getCode())
				.message(ApiResultEnum.FAILURE.getMessage()).build();
	}

}
