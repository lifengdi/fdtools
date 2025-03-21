package site.lifd.core.convert.impl;

import java.util.concurrent.atomic.AtomicBoolean;

import site.lifd.core.convert.AbstractConverter;
import site.lifd.core.util.BooleanUtil;

/**
 * {@link AtomicBoolean}转换器
 *
 * *
 */
public class AtomicBooleanConverter extends AbstractConverter<AtomicBoolean> {
	private static final long serialVersionUID = 1L;

	@Override
	protected AtomicBoolean convertInternal(Object value) {
		if (value instanceof Boolean) {
			return new AtomicBoolean((Boolean) value);
		}
		final String valueStr = convertToStr(value);
		return new AtomicBoolean(BooleanUtil.toBoolean(valueStr));
	}

}
