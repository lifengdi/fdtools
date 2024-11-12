package com.lifd.core.convert.impl;

import com.lifd.core.convert.AbstractConverter;
import com.lifd.core.convert.Convert;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * {@link AtomicIntegerArray}转换器
 *
 * *
 */
public class AtomicIntegerArrayConverter extends AbstractConverter<AtomicIntegerArray> {
	private static final long serialVersionUID = 1L;

	@Override
	protected AtomicIntegerArray convertInternal(Object value) {
		return new AtomicIntegerArray(Convert.convert(int[].class, value));
	}

}
