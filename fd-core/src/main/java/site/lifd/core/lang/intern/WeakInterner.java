package site.lifd.core.lang.intern;

import site.lifd.core.map.WeakConcurrentMap;

import java.lang.ref.WeakReference;

/**
 * 使用WeakHashMap(线程安全)存储对象的规范化对象，注意此对象需单例使用！<br>
 *
 */
public class WeakInterner<T> implements Interner<T>{

	private final WeakConcurrentMap<T, WeakReference<T>> cache = new WeakConcurrentMap<>();

	public T intern(T sample) {
		if (sample == null) {
			return null;
		}
		T val;
		do {
			val = this.cache.computeIfAbsent(sample, WeakReference::new).get();
		} while (val == null);
		return val;
	}
}
