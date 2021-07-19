/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$ValueReference;
import com.google.common.cache.ReferenceEntry;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class LocalCache$WeakEntry
extends WeakReference
implements ReferenceEntry {
    public final int hash;
    public final ReferenceEntry next;
    public volatile LocalCache$ValueReference valueReference;

    public LocalCache$WeakEntry(ReferenceQueue object, Object object2, int n10, ReferenceEntry referenceEntry) {
        super(object2, object);
        this.valueReference = object = LocalCache.unset();
        this.hash = n10;
        this.next = referenceEntry;
    }

    public long getAccessTime() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public int getHash() {
        return this.hash;
    }

    public Object getKey() {
        return this.get();
    }

    public ReferenceEntry getNext() {
        return this.next;
    }

    public ReferenceEntry getNextInAccessQueue() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public ReferenceEntry getNextInWriteQueue() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public ReferenceEntry getPreviousInAccessQueue() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public ReferenceEntry getPreviousInWriteQueue() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public LocalCache$ValueReference getValueReference() {
        return this.valueReference;
    }

    public long getWriteTime() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public void setAccessTime(long l10) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public void setNextInAccessQueue(ReferenceEntry object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public void setNextInWriteQueue(ReferenceEntry object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public void setPreviousInAccessQueue(ReferenceEntry object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public void setPreviousInWriteQueue(ReferenceEntry object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public void setValueReference(LocalCache$ValueReference localCache$ValueReference) {
        this.valueReference = localCache$ValueReference;
    }

    public void setWriteTime(long l10) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }
}

