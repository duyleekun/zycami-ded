/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$WeakEntry;
import com.google.common.cache.ReferenceEntry;
import java.lang.ref.ReferenceQueue;

public final class LocalCache$WeakWriteEntry
extends LocalCache$WeakEntry {
    public ReferenceEntry nextWrite;
    public ReferenceEntry previousWrite;
    public volatile long writeTime = Long.MAX_VALUE;

    public LocalCache$WeakWriteEntry(ReferenceQueue object, Object object2, int n10, ReferenceEntry referenceEntry) {
        super((ReferenceQueue)object, object2, n10, referenceEntry);
        this.nextWrite = object = LocalCache.nullEntry();
        this.previousWrite = object = LocalCache.nullEntry();
    }

    public ReferenceEntry getNextInWriteQueue() {
        return this.nextWrite;
    }

    public ReferenceEntry getPreviousInWriteQueue() {
        return this.previousWrite;
    }

    public long getWriteTime() {
        return this.writeTime;
    }

    public void setNextInWriteQueue(ReferenceEntry referenceEntry) {
        this.nextWrite = referenceEntry;
    }

    public void setPreviousInWriteQueue(ReferenceEntry referenceEntry) {
        this.previousWrite = referenceEntry;
    }

    public void setWriteTime(long l10) {
        this.writeTime = l10;
    }
}

