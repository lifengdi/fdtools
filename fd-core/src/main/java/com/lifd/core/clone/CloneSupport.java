package com.lifd.core.clone;

/**
 * 克隆支持类，提供默认的克隆方法
 * *
 * @param <T> 继承类的类型
 */
public class CloneSupport<T> implements java.lang.Cloneable<T> {

	@SuppressWarnings("unchecked")
	@Override
	public T clone() {
		try {
			return (T) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new CloneRuntimeException(e);
		}
	}

}
