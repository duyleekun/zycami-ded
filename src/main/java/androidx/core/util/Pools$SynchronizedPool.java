/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.util;

import androidx.core.util.Pools$SimplePool;

public class Pools$SynchronizedPool
extends Pools$SimplePool {
    private final Object mLock;

    public Pools$SynchronizedPool(int n10) {
        super(n10);
        Object object;
        this.mLock = object = new Object();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object acquire() {
        Object object = this.mLock;
        synchronized (object) {
            return super.acquire();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean release(Object object) {
        Object object2 = this.mLock;
        synchronized (object2) {
            return super.release(object);
        }
    }
}

