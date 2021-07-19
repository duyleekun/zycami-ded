/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class Striped$2
implements Supplier {
    public Lock get() {
        ReentrantLock reentrantLock = new ReentrantLock(false);
        return reentrantLock;
    }
}

