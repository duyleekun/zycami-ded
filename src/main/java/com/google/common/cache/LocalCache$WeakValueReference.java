/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache$ValueReference;
import com.google.common.cache.ReferenceEntry;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class LocalCache$WeakValueReference
extends WeakReference
implements LocalCache$ValueReference {
    public final ReferenceEntry entry;

    public LocalCache$WeakValueReference(ReferenceQueue referenceQueue, Object object, ReferenceEntry referenceEntry) {
        super(object, referenceQueue);
        this.entry = referenceEntry;
    }

    public LocalCache$ValueReference copyFor(ReferenceQueue referenceQueue, Object object, ReferenceEntry referenceEntry) {
        LocalCache$WeakValueReference localCache$WeakValueReference = new LocalCache$WeakValueReference(referenceQueue, object, referenceEntry);
        return localCache$WeakValueReference;
    }

    public ReferenceEntry getEntry() {
        return this.entry;
    }

    public int getWeight() {
        return 1;
    }

    public boolean isActive() {
        return true;
    }

    public boolean isLoading() {
        return false;
    }

    public void notifyNewValue(Object object) {
    }

    public Object waitForValue() {
        return this.get();
    }
}

