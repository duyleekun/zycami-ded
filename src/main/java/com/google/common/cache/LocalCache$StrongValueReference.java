/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache$ValueReference;
import com.google.common.cache.ReferenceEntry;
import java.lang.ref.ReferenceQueue;

public class LocalCache$StrongValueReference
implements LocalCache$ValueReference {
    public final Object referent;

    public LocalCache$StrongValueReference(Object object) {
        this.referent = object;
    }

    public LocalCache$ValueReference copyFor(ReferenceQueue referenceQueue, Object object, ReferenceEntry referenceEntry) {
        return this;
    }

    public Object get() {
        return this.referent;
    }

    public ReferenceEntry getEntry() {
        return null;
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

