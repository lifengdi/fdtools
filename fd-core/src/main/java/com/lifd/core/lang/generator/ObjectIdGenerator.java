package com.lifd.core.lang.generator;

import com.lifd.core.lang.ObjectId;

/**
 * ObjectId生成器
 *
 * *
 */
public class ObjectIdGenerator implements Generator<String> {
	@Override
	public String next() {
		return ObjectId.next();
	}
}
