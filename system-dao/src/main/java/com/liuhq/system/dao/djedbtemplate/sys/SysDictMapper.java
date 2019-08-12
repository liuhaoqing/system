package com.liuhq.system.dao.djedbtemplate.sys;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuhq.system.dao.DataSource;
import com.liuhq.system.entity.djedbtemplate.sys.SysDict;

@DS(value = DataSource.DJE_DB_TEMPLATE)
public interface SysDictMapper extends BaseMapper<SysDict> {

}