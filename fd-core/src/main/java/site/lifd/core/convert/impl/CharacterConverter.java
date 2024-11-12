package site.lifd.core.convert.impl;

import site.lifd.core.convert.AbstractConverter;
import site.lifd.core.util.BooleanUtil;
import site.lifd.core.util.StrUtil;

/**
 * 字符转换器
 *
 * *
 */
public class CharacterConverter extends AbstractConverter<Character> {
	private static final long serialVersionUID = 1L;

	@Override
	protected Character convertInternal(Object value) {
		if (value instanceof Boolean) {
			return BooleanUtil.toCharacter((Boolean) value);
		} else {
			final String valueStr = convertToStr(value);
			if (StrUtil.isNotBlank(valueStr)) {
				return valueStr.charAt(0);
			}
		}
		return null;
	}

}
