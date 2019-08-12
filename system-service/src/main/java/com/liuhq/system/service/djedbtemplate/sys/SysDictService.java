package com.liuhq.system.service.djedbtemplate.sys;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liuhq.system.common.page.Page;
import com.liuhq.system.dao.djedbtemplate.sys.dto.SysDictDto;
import com.liuhq.system.dao.djedbtemplate.sys.vo.SysDictVo;
import com.liuhq.system.entity.djedbtemplate.sys.SysDict;

public interface SysDictService extends IService<SysDict> {

	Page<SysDictVo> pageForCondition(SysDictDto dto);
	
}
