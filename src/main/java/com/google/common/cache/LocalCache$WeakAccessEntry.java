/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$WeakEntry;
import com.google.common.cache.ReferenceEntry;
import java.lang.ref.ReferenceQueue;

public final class LocalCache$WeakAccessEntry
extends LocalCache$WeakEntry {
    public volatile long accessTime = Long.MAX_VALUE;
    public ReferenceEntry nextAccess;
    public ReferenceEntry previousAccess;

    public LocalCache$WeakAccessEntry(ReferenceQueue object, Object object2, int n10, ReferenceEntry referenceEntry) {
        super((ReferenceQueue)object, object2, n10, referenceEntry);
        this.nextAccess = object = LocalCache.nullEntry();
        this.previousAccess = object = LocalCache.nullEntry();
    }

    public long getAccessTime() {
        return this.accessTime;
    }

    public ReferenceEntry getNextInAccessQueue() {
        return this.nextAccess;
    }

    public ReferenceEntry getPreviousInAccessQueue() {
        return this.previousAccess;
    }

    public void setAccessTime(long l10) {
        this.accessTime = l10;
    }

    public void setNextInAccessQueue(ReferenceEntry referenceEntry) {
        this.nextAccess = referenceEntry;
    }

    public void setPreviousInAccessQueue(ReferenceEntry referenceEntry) {
        this.previousAccess = referenceEntry;
    }
}

