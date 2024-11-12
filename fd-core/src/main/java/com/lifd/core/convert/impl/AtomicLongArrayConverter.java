package com.lifd.core.convert.impl;

import com.lifd.core.convert.AbstractConverter;
import com.lifd.core.convert.Convert;

import java.util.concurrent.atomic.AtomicLongArray;

/**
 * {@link AtomicLongArray}转换器
 *
 * *
 */
public class AtomicLongArrayConverter extends AbstractConverter<AtomicLongArray> {
	private static final long serialVersionUID = 1L;

	@Override
	protected AtomicLongArray convertInternal(Object value) {
		return new AtomicLongArray(Convert.convert(long[].class, value));
	}

}
