package site.lifd.core.lang.generator;

import site.lifd.core.lang.ObjectId;

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
