package com.liuhq.system.service.djedbtemplate.sys;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuhq.system.common.page.Page;
import com.liuhq.system.common.page.PageUtils;
import com.liuhq.system.dao.djedbtemplate.sys.SysDictMapper;
import com.liuhq.system.dao.djedbtemplate.sys.dto.SysDictDto;
import com.liuhq.system.dao.djedbtemplate.sys.vo.SysDictVo;
import com.liuhq.system.entity.djedbtemplate.sys.SysDict;
import com.liuhq.system.service.BaseService;

@Service
public class SysDictService extends BaseService<SysDict, SysDictMapper> {

	public Page<SysDictVo> pageForCondition(SysDictDto dto) {
		dto = Optional.<SysDictDto>ofNullable(dto).orElseGet(SysDictDto::new);
		PageHelper.<SysDict>startPage(dto.getPageNum(), dto.getPageSize());
		return PageUtils.<SysDictVo, SysDict>page(new PageInfo<SysDict>(
				baseMapper.selectList(new QueryWrapper<SysDict>().lambda().eq(SysDict::getCode, dto.getCode())
						.like(StringUtils.isNotBlank(dto.getType()), SysDict::getType, dto.getType()))));
	}

}
