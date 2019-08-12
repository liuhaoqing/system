package com.liuhq.system.entity.djedbtemplate.sys;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("sys_dict")
public class SysDict implements Serializable {

	private static final long serialVersionUID = 7915018577399312827L;

	@TableId(type = IdType.AUTO)
	private Integer id;

	private String name;

	private String type;

	private String code;

	private String value;

	private Integer orderNum;

	private String description;

	private Integer delFlag;

}
