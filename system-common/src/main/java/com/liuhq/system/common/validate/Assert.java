package com.liuhq.system.common.validate;

import org.apache.commons.lang3.StringUtils;

import com.liuhq.system.common.exception.BaseException;

/**
 * 数据校验工具类
 */
public class Assert {
	
	/**
	 * 抛出异常
	 */
	public static void exception(String message) {
		throw new BaseException(message);
	}

	/**
	 * 字符串非空校验
	 */
	public static void isBlank(String str, String message) {
		if (StringUtils.isBlank(str))
			throw new BaseException(message);
	}

	/**
	 * 对象非空校验
	 */
	public static void isNull(Object object, String message) {
		if (object == null)
			throw new BaseException(message);
	}

	/**
	 * 布尔校验
	 */
	public static void isTrue(boolean result, String message) {
		if (!result)
			throw new BaseException(message);
	}

}
