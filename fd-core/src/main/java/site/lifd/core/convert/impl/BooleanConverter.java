package site.lifd.core.convert.impl;

import site.lifd.core.convert.AbstractConverter;
import site.lifd.core.util.BooleanUtil;

/**
 * 布尔转换器
 *
 * <p>
 * 对象转为boolean，规则如下：
 * </p>
 * <pre>
 *     1、数字0为false，其它数字为true
 *     2、转换为字符串，形如"true", "yes", "y", "t", "ok", "1", "on", "是", "对", "真", "對", "√"为true，其它字符串为false.
 * </pre>
 *
 */
public class BooleanConverter extends AbstractConverter<Boolean> {
	private static final long serialVersionUID = 1L;

	@Override
	protected Boolean convertInternal(Object value) {
		if (value instanceof Number) {
			// 0为false，其它数字为true
			return 0 != ((Number) value).doubleValue();
		}
		//Object不可能出现Primitive类型，故忽略
		return BooleanUtil.toBoolean(convertToStr(value));
	}

}
