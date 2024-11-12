package com.lifd.core.lang.generator;

import com.lifd.core.util.IdUtil;

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
