package site.lifd.core.convert.impl;

import java.util.UUID;

import site.lifd.core.convert.AbstractConverter;

/**
 * UUID对象转换器转换器
 *
 * *
 *
 */
public class UUIDConverter extends AbstractConverter<UUID> {
	private static final long serialVersionUID = 1L;

	@Override
	protected UUID convertInternal(Object value) {
		return UUID.fromString(convertToStr(value));
	}

}
