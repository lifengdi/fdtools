package site.lifd.core.lang.generator;

import site.lifd.core.util.IdUtil;

/**
 * UUID生成器
 *
 * *
 */
public class UUIDGenerator implements Generator<String> {
	@Override
	public String next() {
		return IdUtil.fastUUID();
	}
}
