package com.liuhq.system.common.sql;

import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Intercepts(value = {
		@Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class }) })
@Slf4j
public class UpdateInterceptor implements Interceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		Object[] args = invocation.getArgs();
		MappedStatement ms = (MappedStatement) args[0];
		Object parameter = args[1];
		Executor executor = (Executor) invocation.getTarget();
		BoundSql boundSql = ms.getBoundSql(parameter);
		log.info(" Preparing: {}", boundSql.getSql().replaceAll("\\s{1,}", " "));
		log.info(SqlUtils.getSqlParamter(parameter, boundSql));
		int count = executor.update(ms, parameter);
		log.info("影响{}行数据", count);
		return count;
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
	}

}
