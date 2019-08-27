package com.liuhq.system.dao.djedbtemplate.sys.dto;

import com.liuhq.system.common.page.PagePojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "字典表查询条件")
public class SysDictDto extends PagePojo{

	@ApiModelProperty(value = "类型")
	private String type;
	
	@ApiModelProperty(value = "code")
	private String code;
	
}
