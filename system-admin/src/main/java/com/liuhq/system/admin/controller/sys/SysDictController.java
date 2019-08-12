package com.liuhq.system.admin.controller.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liuhq.system.common.page.Page;
import com.liuhq.system.common.response.ApiResult;
import com.liuhq.system.common.response.ApiResultUtils;
import com.liuhq.system.dao.djedbtemplate.sys.dto.SysDictDto;
import com.liuhq.system.dao.djedbtemplate.sys.vo.SysDictVo;
import com.liuhq.system.service.djedbtemplate.sys.SysDictService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/sysdict")
@Api(tags = { "字典表接口" })
@Slf4j
public class SysDictController {

	@Autowired
	private SysDictService sysDictService;

	@ApiOperation(value = "分页查询列表")
	@PostMapping("/page")
	public ApiResult<Page<SysDictVo>> page(@RequestBody(required = false) SysDictDto dto) {
		log.info("分页查询列表...");
		return ApiResultUtils.<Page<SysDictVo>>success(sysDictService.pageForCondition(dto));
	}

}
