package com.liuhq.system.common.exception;

import com.liuhq.system.common.constant.Const;
import com.liuhq.system.common.response.ApiResultEnum;

import lombok.Getter;
import lombok.Setter;

public class BaseException extends RuntimeException{

	private static final long serialVersionUID = 3752144405368234956L;
	
	/** 状态码 **/
	@Getter
	@Setter
	private Integer code;

	public BaseException() {
	}

	public BaseException(ApiResultEnum e) {
		super(e.getMessage());
		this.code = e.getCode();
	}

	public BaseException(String message) {
		super(message);
		this.code = Const.RESPONSE_INTERNAL_FAILURE_STATUS_CODE;
	}

	public BaseException(String message, Integer code) {
		super(message);
		this.code = code;
	}

}
