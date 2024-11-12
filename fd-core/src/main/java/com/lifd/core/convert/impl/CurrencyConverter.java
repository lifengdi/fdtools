package com.lifd.core.convert.impl;

import java.util.Currency;

import com.lifd.core.convert.AbstractConverter;

/**
 * 货币{@link Currency} 转换器
 *
 * *
 */
public class CurrencyConverter extends AbstractConverter<Currency> {
	private static final long serialVersionUID = 1L;

	@Override
	protected Currency convertInternal(Object value) {
		return Currency.getInstance(convertToStr(value));
	}

}
