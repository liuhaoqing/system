package com.liuhq.system.common.sql;

import java.util.Map;

import org.apache.ibatis.mapping.BoundSql;

import com.alibaba.fastjson.JSONObject;

public class SqlUtils {

	@SuppressWarnings("unchecked")
	public static String getSqlParamter(Object parameter, BoundSql boundSql) {
		StringBuffer paramterInfo = new StringBuffer(" Parameters: ");
		try {
			Map<String, Object> map = JSONObject.parseObject(JSONObject.toJSONString(parameter), Map.class);
			boundSql.getParameterMappings().forEach(param -> {
				Map<String, Object> temp = null;
				// 获取参数名称
				String property = param.getProperty();
				String[] keys = property.split("\\.");
				Object value = null;
				for (int i = 0; i < keys.length; i++) {
					String key = keys[i];
					if (i == keys.length - 1 && i != 0) {
						value = temp.get(key);
					} else {
						if (i == 0) {
							if (keys.length == 1) {
								value = map.get(key);
							} else {
								temp = JSONObject.parseObject(JSONObject.toJSONString(map.get(key)), Map.class);
							}
						} else {
							temp = JSONObject.parseObject(JSONObject.toJSONString(temp.get(key)), Map.class);
						}
					}
				}
				paramterInfo.append(value + "(" + param.getJavaType().getSimpleName() + ")" + "\t");
			});
		} catch (Exception e) {
			paramterInfo.append(parameter);
		}
		return paramterInfo.toString();
	}

}
