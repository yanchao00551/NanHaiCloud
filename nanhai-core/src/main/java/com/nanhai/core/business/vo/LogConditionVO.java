package com.nanhai.core.business.vo;


import com.nanhai.core.framework.object.BaseConditionVO;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class LogConditionVO extends BaseConditionVO {
	private Long userId;
	private String logLevel;
	private String type;
	private Boolean spider;
}

