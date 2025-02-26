package site.lifd.core.lang.func;

import site.lifd.core.exceptions.ExceptionUtil;

import java.io.Serializable;

/**
 * 函数对象<br>
 * 接口灵感来自于<a href="http://actframework.org/">ActFramework</a><br>
 * 一个函数接口代表一个一个函数，用于包装一个函数为对象<br>
 * 在JDK8之前，Java的函数并不能作为参数传递，也不能作为返回值存在，此接口用于将一个函数包装成为一个对象，从而传递对象
 *
 * *
 * 
 */
@FunctionalInterface
public interface VoidFunc1<P> extends Serializable {

	/**
	 * 执行函数
	 *
	 * @param parameter 参数
	 * @throws Exception 自定义异常
	 */
	void call(P parameter) throws Exception;

	/**
	 * 执行函数，异常包装为RuntimeException
	 *
	 * @param parameter 参数
	 * 
	 */
	default void callWithRuntimeException(P parameter){
		try {
			call(parameter);
		} catch (Exception e) {
			throw ExceptionUtil.wrapRuntime(e);
		}
	}
}
