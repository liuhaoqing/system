package com.liuhq.system.common.utils;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public class JsonUtils {

	@SuppressWarnings("unchecked")
	public static Object getValueByKey(String json, String key) {
		Map<String, Object> map = JSONObject.parseObject(json, Map.class);
		String[] keys = key.split("\\.");
		for (int i = 0; i < keys.length;) {
			String k = keys[i];
			return i != keys.length - 1
					? getValueByKey(JSONObject.toJSONString(map.get(k)), key.substring(k.length() + 1))
					: map.get(k);
		}
		return null;
	}

}
