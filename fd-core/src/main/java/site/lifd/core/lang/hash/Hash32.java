package site.lifd.core.lang.hash;

/**
 * Hash计算接口
 *
 * @param <T> 被计算hash的对象类型
 */
@FunctionalInterface
public interface Hash32<T> extends Hash<T>{
	/**
	 * 计算Hash值
	 *
	 * @param t 对象
	 * @return hash
	 */
	int hash32(T t);

	@Override
	default Number hash(T t){
		return hash32(t);
	}
}
