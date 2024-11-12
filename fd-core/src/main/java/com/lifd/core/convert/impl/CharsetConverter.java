package com.lifd.core.convert.impl;

import java.nio.charset.Charset;

import com.lifd.core.convert.AbstractConverter;
import com.lifd.core.util.CharsetUtil;

/**
 * 编码对象转换器
 * *
 */
public class CharsetConverter extends AbstractConverter<Charset>{
	private static final long serialVersionUID = 1L;

	@Override
	protected Charset convertInternal(Object value) {
		return CharsetUtil.charset(convertToStr(value));
	}

}
