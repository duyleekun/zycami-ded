/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ForwardingCondition;
import com.google.common.util.concurrent.Striped$WeakSafeReadWriteLock;
import java.util.concurrent.locks.Condition;

public final class Striped$WeakSafeCondition
extends ForwardingCondition {
    private final Condition delegate;
    private final Striped$WeakSafeReadWriteLock strongReference;

    public Striped$WeakSafeCondition(Condition condition, Striped$WeakSafeReadWriteLock striped$WeakSafeReadWriteLock) {
        this.delegate = condition;
        this.strongReference = striped$WeakSafeReadWriteLock;
    }

    public Condition delegate() {
        return this.delegate;
    }
}

