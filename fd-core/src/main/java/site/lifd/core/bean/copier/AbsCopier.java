package site.lifd.core.bean.copier;

import site.lifd.core.lang.copier.Copier;
import site.lifd.core.util.ObjectUtil;

/**
 * 抽象的对象拷贝封装，提供来源对象、目标对象持有
 *
 * @param <S> 来源对象类型
 * @param <T> 目标对象类型
 * *
 */
public abstract class AbsCopier<S, T> implements Copier<T> {

	protected final S source;
	protected final T target;
	/**
	 * 拷贝选项
	 */
	protected final CopyOptions copyOptions;

	public AbsCopier(S source, T target, CopyOptions copyOptions) {
		this.source = source;
		this.target = target;
		this.copyOptions = ObjectUtil.defaultIfNull(copyOptions, CopyOptions::create);
	}
}
