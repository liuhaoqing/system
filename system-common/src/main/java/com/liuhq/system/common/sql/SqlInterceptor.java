package com.liuhq.system.common.sql;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

import lombok.extern.slf4j.Slf4j;

@Component
@Intercepts(value = {
		@Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class,
				RowBounds.class, ResultHandler.class }),
		@Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class,
				RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class }) })
@Slf4j
public class SqlInterceptor implements Interceptor {

	@SuppressWarnings("rawtypes")
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		Object[] args = invocation.getArgs();
		MappedStatement ms = (MappedStatement) args[0];
		Object parameter = args[1];
		RowBounds rowBounds = (RowBounds) args[2];
		Executor executor = (Executor) invocation.getTarget();
		BoundSql boundSql = args.length == 4 ? ms.getBoundSql(parameter) : (BoundSql) args[5];
		CacheKey cacheKey = args.length == 4 ? executor.createCacheKey(ms, parameter, rowBounds, boundSql)
				: (CacheKey) args[4];
		printSqlParamter(parameter, boundSql);
		log.info(" Preparing: " + boundSql.getSql());
		List<Object> list = executor.query(ms, parameter, rowBounds, (ResultHandler) args[3], cacheKey, boundSql);
		log.info("查询到" + list.size() + "条记录");
		if (CollectionUtils.isNotEmpty(list)) {
			list.forEach(obj -> {
				log.info(JSONObject.toJSONString(obj));
			});
		}
		return list;
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
	}

	@SuppressWarnings("unchecked")
	private void printSqlParamter(Object parameter, BoundSql boundSql) {
		StringBuffer paramterInfo = new StringBuffer(" Parameters: ");
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
		log.info(paramterInfo.toString());
	}

}
