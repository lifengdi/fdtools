package site.lifd.core.lang.mutable;

import site.lifd.core.util.ObjUtil;

import java.io.Serializable;

/**
 * 可变{@code Object}
 *
 * @param <T> 可变的类型
 * 
 */
public class MutableObj<T> implements Mutable<T>, Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 构建MutableObj
	 * @param value 被包装的值
	 * @param <T> 值类型
	 * @return MutableObj
	 * 
	 */
	public static <T> MutableObj<T> of(T value){
		return new MutableObj<>(value);
	}

	private T value;

	/**
	 * 构造，空值
	 */
	public MutableObj() {
	}

	/**
	 * 构造
	 *
	 * @param value 值
	 */
	public MutableObj(final T value) {
		this.value = value;
	}

	// -----------------------------------------------------------------------
	@Override
	public T get() {
		return this.value;
	}

	@Override
	public void set(final T value) {
		this.value = value;
	}

	// -----------------------------------------------------------------------
	@Override
	public boolean equals(final Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (this.getClass() == obj.getClass()) {
			final MutableObj<?> that = (MutableObj<?>) obj;
			return ObjUtil.equals(this.value, that.value);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return value == null ? 0 : value.hashCode();
	}

	// -----------------------------------------------------------------------
	@Override
	public String toString() {
		return value == null ? "null" : value.toString();
	}

}
