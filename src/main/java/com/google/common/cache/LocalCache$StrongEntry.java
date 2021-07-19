/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$AbstractReferenceEntry;
import com.google.common.cache.LocalCache$ValueReference;
import com.google.common.cache.ReferenceEntry;

public class LocalCache$StrongEntry
extends LocalCache$AbstractReferenceEntry {
    public final int hash;
    public final Object key;
    public final ReferenceEntry next;
    public volatile LocalCache$ValueReference valueReference;

    public LocalCache$StrongEntry(Object object, int n10, ReferenceEntry referenceEntry) {
        LocalCache$ValueReference localCache$ValueReference;
        this.valueReference = localCache$ValueReference = LocalCache.unset();
        this.key = object;
        this.hash = n10;
        this.next = referenceEntry;
    }

    public int getHash() {
        return this.hash;
    }

    public Object getKey() {
        return this.key;
    }

    public ReferenceEntry getNext() {
        return this.next;
    }

    public LocalCache$ValueReference getValueReference() {
        return this.valueReference;
    }

    public void setValueReference(LocalCache$ValueReference localCache$ValueReference) {
        this.valueReference = localCache$ValueReference;
    }
}

