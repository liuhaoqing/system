package com.liuhq.system.dao.djedbtemplate.sys.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ApiModel(value = "字典表参数")
public class SysDictVo {

	@ApiModelProperty(value = "ID")
	private Integer id;
	
	@ApiModelProperty(value = "名称")
	private String name;

	@ApiModelProperty(value = "类型")
	private String type;
	
	@ApiModelProperty(value = "key")
	private String code;
	
	@ApiModelProperty(value = "值")
	private String value;
	
	@ApiModelProperty(value = "排序")
	private Integer orderNum;
	
	@ApiModelProperty(value = "描述")
	private String description;
	
	@ApiModelProperty(value = "删除标识")
	private Integer delFlag;
	
}