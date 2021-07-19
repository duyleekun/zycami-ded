/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache$ValueReference;
import com.google.common.cache.ReferenceEntry;
import java.lang.ref.ReferenceQueue;

public final class LocalCache$1
implements LocalCache$ValueReference {
    public LocalCache$ValueReference copyFor(ReferenceQueue referenceQueue, Object object, ReferenceEntry referenceEntry) {
        return this;
    }

    public Object get() {
        return null;
    }

    public ReferenceEntry getEntry() {
        return null;
    }

    public int getWeight() {
        return 0;
    }

    public boolean isActive() {
        return false;
    }

    public boolean isLoading() {
        return false;
    }

    public void notifyNewValue(Object object) {
    }

    public Object waitForValue() {
        return null;
    }
}

