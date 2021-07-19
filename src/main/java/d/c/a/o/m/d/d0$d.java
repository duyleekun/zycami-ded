/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.m.d;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public final class d0$d
implements Lock {
    public void lock() {
    }

    public void lockInterruptibly() {
    }

    public Condition newCondition() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Should not be called");
        throw unsupportedOperationException;
    }

    public boolean tryLock() {
        return true;
    }

    public boolean tryLock(long l10, TimeUnit timeUnit) {
        return true;
    }

    public void unlock() {
    }
}

