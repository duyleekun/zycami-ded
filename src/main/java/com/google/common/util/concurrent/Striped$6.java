/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Striped$WeakSafeReadWriteLock;
import java.util.concurrent.locks.ReadWriteLock;

public final class Striped$6
implements Supplier {
    public ReadWriteLock get() {
        Striped$WeakSafeReadWriteLock striped$WeakSafeReadWriteLock = new Striped$WeakSafeReadWriteLock();
        return striped$WeakSafeReadWriteLock;
    }
}

