package com.liuhq.system.common.response;

import com.liuhq.system.common.constant.Const;

/**
 * 返回结果状态码和信息枚举类
 */
public enum ApiResultEnum {

	SUCCESS(Const.RESPONSE_SUCCESS_STATUS_CODE, Const.RESPONSE_SUCCESS_MESSAGE), // 成功
	FAILURE(Const.RESPONSE_INTERNAL_FAILURE_STATUS_CODE, Const.RESPONSE_INTERNAL_FAILURE_MESSAGE), // 失败
	UNKNOWN(Const.RESPONSE_UNKNOWN_FAILURE_STATUS_CODE, Const.RESPONSE_UNKNOWN_FAILURE_MESSAGE),// 未知异常
	;

	/** 状态码 **/
	private Integer code;

	/** 返回信息 **/
	private String message;

	private ApiResultEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
