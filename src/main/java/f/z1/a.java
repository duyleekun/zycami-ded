/*
 * Decompiled with CFR 0.151.
 */
package f.z1;

import f.h2.t.c0;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class a {
    private static final Object a(ReentrantReadWriteLock serializable, f.h2.s.a object) {
        serializable = ((ReentrantReadWriteLock)serializable).readLock();
        ((ReentrantReadWriteLock.ReadLock)serializable).lock();
        int n10 = 1;
        try {
            object = object.invoke();
            return object;
        }
        finally {
            c0.d(n10);
            ((ReentrantReadWriteLock.ReadLock)serializable).unlock();
            c0.c(n10);
        }
    }

    private static final Object b(Lock lock, f.h2.s.a object) {
        lock.lock();
        int n10 = 1;
        try {
            object = object.invoke();
            return object;
        }
        finally {
            c0.d(n10);
            lock.unlock();
            c0.c(n10);
        }
    }

    private static final Object c(ReentrantReadWriteLock serializable, f.h2.s.a object) {
        int n10;
        ReentrantReadWriteLock.ReadLock readLock = ((ReentrantReadWriteLock)serializable).readLock();
        int n11 = ((ReentrantReadWriteLock)serializable).getWriteHoldCount();
        int n12 = 0;
        n11 = n11 == 0 ? ((ReentrantReadWriteLock)serializable).getReadHoldCount() : 0;
        for (n10 = 0; n10 < n11; ++n10) {
            readLock.unlock();
        }
        serializable = ((ReentrantReadWriteLock)serializable).writeLock();
        ((ReentrantReadWriteLock.WriteLock)serializable).lock();
        n10 = 1;
        try {
            object = object.invoke();
            return object;
        }
        finally {
            c0.d(n10);
            while (n12 < n11) {
                readLock.lock();
                ++n12;
            }
            ((ReentrantReadWriteLock.WriteLock)serializable).unlock();
            c0.c(n10);
        }
    }
}

