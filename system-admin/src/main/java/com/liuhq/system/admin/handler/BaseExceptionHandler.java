package com.liuhq.system.admin.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.liuhq.system.common.exception.BaseException;
import com.liuhq.system.common.response.ApiResult;
import com.liuhq.system.common.response.ApiResultUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * 异常处理类
 */
@RestControllerAdvice
@Slf4j
public class BaseExceptionHandler {

	/**
	 * 系统异常
	 */
	@ExceptionHandler(value = { BaseException.class })
	public ApiResult<String> handleBaseException(BaseException e) {
		return ApiResultUtils.failure(e);
	}

	/**
	 * 未知异常
	 */
	@ExceptionHandler(value = { Exception.class })
	public ApiResult<String> handleBaseException(Exception e) {
		log.error("未知异常：",e);
		return ApiResultUtils.failure();
	}

}
