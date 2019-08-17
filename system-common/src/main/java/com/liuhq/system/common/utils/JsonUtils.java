package com.liuhq.system.common.utils;

import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class JsonUtils {

	@SuppressWarnings("unchecked")
	public static Object getValueByKey(String json, String key) {
		if (JSON.isValidObject(json)) {
			Map<String, Object> map = JSONObject.parseObject(json, Map.class);
			String[] keys = key.split("\\.");
			String k = keys[0];
			return keys.length > 1 ? getValueByKey(JSONObject.toJSONString(map.get(k)), key.substring(k.length() + 1))
					: map.get(k);
		}
		return json;
	}

}
