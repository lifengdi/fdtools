package com.lifd.core.annotation;

import com.lifd.core.lang.Assert;
import com.lifd.core.util.ObjectUtil;
import com.lifd.core.util.ReflectUtil;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * {@link AnnotationAttribute}的基本实现
 *
 * */
public class CacheableAnnotationAttribute implements AnnotationAttribute {

	private volatile boolean valueInvoked;
	private Object value;

	private boolean defaultValueInvoked;
	private Object defaultValue;

	private final Annotation annotation;
	private final Method attribute;

	public CacheableAnnotationAttribute(Annotation annotation, Method attribute) {
		Assert.notNull(annotation, "annotation must not null");
		Assert.notNull(attribute, "attribute must not null");
		this.annotation = annotation;
		this.attribute = attribute;
		this.valueInvoked = false;
		this.defaultValueInvoked = false;
	}

	@Override
	public Annotation getAnnotation() {
		return this.annotation;
	}

	@Override
	public Method getAttribute() {
		return this.attribute;
	}

	@Override
	public Object getValue() {
		if (!valueInvoked) {
			synchronized (this) {
				if (!valueInvoked) {
					valueInvoked = true;
					value = ReflectUtil.invoke(annotation, attribute);
				}
			}
		}
		return value;
	}

	@Override
	public boolean isValueEquivalentToDefaultValue() {
		if (!defaultValueInvoked) {
			defaultValue = attribute.getDefaultValue();
			defaultValueInvoked = true;
		}
		return ObjectUtil.equals(getValue(), defaultValue);
	}

}
