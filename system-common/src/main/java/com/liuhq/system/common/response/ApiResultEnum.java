package com.liuhq.system.common.response;

import com.liuhq.system.common.constant.Const;

import lombok.Getter;
import lombok.Setter;

/**
 * 返回结果状态码和信息枚举类
 */
public enum ApiResultEnum {

	SUCCESS(Const.RESPONSE_SUCCESS_STATUS_CODE, Const.RESPONSE_SUCCESS_MESSAGE), // 成功
	FAILURE(Const.RESPONSE_INTERNAL_FAILURE_STATUS_CODE, Const.RESPONSE_INTERNAL_FAILURE_MESSAGE), // 失败
	UNKNOWN(Const.RESPONSE_UNKNOWN_FAILURE_STATUS_CODE, Const.RESPONSE_UNKNOWN_FAILURE_MESSAGE),// 未知异常
	;

	/** 状态码 **/
	@Getter
	@Setter
	private Integer code;

	/** 返回信息 **/
	@Getter
	@Setter
	private String message;

	private ApiResultEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

}
