package site.lifd.core.bean;

import site.lifd.core.lang.func.Func0;
import site.lifd.core.map.WeakConcurrentMap;

/**
 * Bean属性缓存<br>
 * 缓存用于防止多次反射造成的性能问题
 *
 * */
public enum BeanDescCache {
	INSTANCE;

	private final WeakConcurrentMap<Class<?>, BeanDesc> bdCache = new WeakConcurrentMap<>();

	/**
	 * 获得属性名和{@link BeanDesc}Map映射
	 *
	 * @param beanClass Bean的类
	 * @param supplier  对象不存在时创建对象的函数
	 * @return 属性名和{@link BeanDesc}映射
	 *
	 */
	public BeanDesc getBeanDesc(Class<?> beanClass, Func0<BeanDesc> supplier) {
		return bdCache.computeIfAbsent(beanClass, (key)->supplier.callWithRuntimeException());
	}

	/**
	 * 清空全局的Bean属性缓存
	 *
	 *
	 */
	public void clear() {
		this.bdCache.clear();
	}
}
