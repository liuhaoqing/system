package com.liuhq.system.common.sql;

import org.apache.ibatis.mapping.BoundSql;

import com.alibaba.fastjson.JSONObject;
import com.liuhq.system.common.utils.JsonUtils;

public class SqlUtils {

	public static String getSqlParamter(Object parameter, BoundSql boundSql) {
		StringBuffer paramterInfo = new StringBuffer(" Parameters: ");
		try {
			boundSql.getParameterMappings().forEach(param -> {
				try {
					paramterInfo
							.append(JsonUtils.getValueByKey(JSONObject.toJSONString(parameter), param.getProperty()));
				} catch (Exception e) {
					paramterInfo.append(parameter);
				}
			});
		} catch (Exception e) {
			paramterInfo.append(parameter);
		}
		return paramterInfo.toString();
	}

}
