/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class Striped$5
implements Supplier {
    public ReadWriteLock get() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        return reentrantReadWriteLock;
    }
}

