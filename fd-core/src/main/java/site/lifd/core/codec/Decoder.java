package site.lifd.core.codec;

/**
 * 解码接口
 *
 * @param <T> 被解码的数据类型
 * @param <R> 解码后的数据类型
 */
public interface Decoder<T, R> {

	/**
	 * 执行解码
	 *
	 * @param encoded 被解码的数据
	 * @return 解码后的数据
	 */
	R decode(T encoded);
}
