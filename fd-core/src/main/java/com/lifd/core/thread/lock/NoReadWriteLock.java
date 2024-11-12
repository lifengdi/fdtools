package com.lifd.core.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * 无锁的读写锁实现
 *
 * *
 */
public class NoReadWriteLock implements ReadWriteLock {
	@Override
	public Lock readLock() {
		return NoLock.INSTANCE;
	}

	@Override
	public Lock writeLock() {
		return NoLock.INSTANCE;
	}
}
