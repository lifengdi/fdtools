package com.lifd.core.lang.hash;

/**
 * Hash计算接口
 *
 * @param <T> 被计算hash的对象类型
 * *
 */
@FunctionalInterface
public interface Hash<T> {
	/**
	 * 计算Hash值
	 *
	 * @param t 对象
	 * @return hash
	 */
	Number hash(T t);
}
