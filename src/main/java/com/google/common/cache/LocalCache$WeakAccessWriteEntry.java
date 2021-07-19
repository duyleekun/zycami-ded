/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$WeakEntry;
import com.google.common.cache.ReferenceEntry;
import java.lang.ref.ReferenceQueue;

public final class LocalCache$WeakAccessWriteEntry
extends LocalCache$WeakEntry {
    public volatile long accessTime;
    public ReferenceEntry nextAccess;
    public ReferenceEntry nextWrite;
    public ReferenceEntry previousAccess;
    public ReferenceEntry previousWrite;
    public volatile long writeTime;

    public LocalCache$WeakAccessWriteEntry(ReferenceQueue object, Object object2, int n10, ReferenceEntry referenceEntry) {
        super((ReferenceQueue)object, object2, n10, referenceEntry);
        ReferenceEntry referenceEntry2;
        long l10;
        this.accessTime = l10 = Long.MAX_VALUE;
        this.nextAccess = referenceEntry2 = LocalCache.nullEntry();
        this.previousAccess = referenceEntry2 = LocalCache.nullEntry();
        this.writeTime = l10;
        this.nextWrite = object = LocalCache.nullEntry();
        this.previousWrite = object = LocalCache.nullEntry();
    }

    public long getAccessTime() {
        return this.accessTime;
    }

    public ReferenceEntry getNextInAccessQueue() {
        return this.nextAccess;
    }

    public ReferenceEntry getNextInWriteQueue() {
        return this.nextWrite;
    }

    public ReferenceEntry getPreviousInAccessQueue() {
        return this.previousAccess;
    }

    public ReferenceEntry getPreviousInWriteQueue() {
        return this.previousWrite;
    }

    public long getWriteTime() {
        return this.writeTime;
    }

    public void setAccessTime(long l10) {
        this.accessTime = l10;
    }

    public void setNextInAccessQueue(ReferenceEntry referenceEntry) {
        this.nextAccess = referenceEntry;
    }

    public void setNextInWriteQueue(ReferenceEntry referenceEntry) {
        this.nextWrite = referenceEntry;
    }

    public void setPreviousInAccessQueue(ReferenceEntry referenceEntry) {
        this.previousAccess = referenceEntry;
    }

    public void setPreviousInWriteQueue(ReferenceEntry referenceEntry) {
        this.previousWrite = referenceEntry;
    }

    public void setWriteTime(long l10) {
        this.writeTime = l10;
    }
}

