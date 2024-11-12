package site.lifd.core.convert.impl;

import site.lifd.core.convert.AbstractConverter;

import java.util.Optional;

/**
 *
 * {@link Optional}对象转换器
 *
 */
public class OptionalConverter extends AbstractConverter<Optional<?>> {
	private static final long serialVersionUID = 1L;

	@Override
	protected Optional<?> convertInternal(Object value) {
		return Optional.ofNullable(value);
	}

}
