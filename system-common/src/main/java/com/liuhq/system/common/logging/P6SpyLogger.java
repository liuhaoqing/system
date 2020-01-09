package com.liuhq.system.common.logging;

import com.alibaba.druid.sql.SQLUtils;
import com.p6spy.engine.spy.appender.MessageFormattingStrategy;
import org.apache.commons.lang3.StringUtils;

public class P6SpyLogger implements MessageFormattingStrategy {

	@Override
	public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared,
			String sql, String url) {
		return "resultset".equals(category) ? sql
				: StringUtils.isNotBlank(sql)
						? "[ " + now + " ] --- | took " + elapsed + "ms | " + category + " | connection " + connectionId
								+ "\n " + SQLUtils.formatMySql(sql) + ";"
						: StringUtils.EMPTY;
	}

}
