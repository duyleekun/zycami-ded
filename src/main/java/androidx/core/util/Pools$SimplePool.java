/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.util;

import androidx.core.util.Pools$Pool;

public class Pools$SimplePool
implements Pools$Pool {
    private final Object[] mPool;
    private int mPoolSize;

    public Pools$SimplePool(int n10) {
        if (n10 > 0) {
            Object[] objectArray = new Object[n10];
            this.mPool = objectArray;
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The max pool size must be > 0");
        throw illegalArgumentException;
    }

    private boolean isInPool(Object object) {
        int n10;
        for (int i10 = 0; i10 < (n10 = this.mPoolSize); ++i10) {
            Object object2 = this.mPool[i10];
            if (object2 != object) continue;
            return true;
        }
        return false;
    }

    public Object acquire() {
        int n10 = this.mPoolSize;
        if (n10 > 0) {
            int n11 = n10 + -1;
            Object[] objectArray = this.mPool;
            Object object = objectArray[n11];
            objectArray[n11] = null;
            this.mPoolSize = n10 += -1;
            return object;
        }
        return null;
    }

    public boolean release(Object object) {
        int n10 = this.isInPool(object);
        if (n10 == 0) {
            n10 = this.mPoolSize;
            Object[] objectArray = this.mPool;
            int n11 = objectArray.length;
            if (n10 < n11) {
                objectArray[n10] = object;
                int n12 = 1;
                this.mPoolSize = n10 += n12;
                return n12 != 0;
            }
            return false;
        }
        object = new IllegalStateException("Already in the pool!");
        throw object;
    }
}

