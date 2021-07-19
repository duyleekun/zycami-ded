/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$StrongEntry;
import com.google.common.cache.ReferenceEntry;

public final class LocalCache$StrongAccessEntry
extends LocalCache$StrongEntry {
    public volatile long accessTime = Long.MAX_VALUE;
    public ReferenceEntry nextAccess;
    public ReferenceEntry previousAccess;

    public LocalCache$StrongAccessEntry(Object object, int n10, ReferenceEntry referenceEntry) {
        super(object, n10, referenceEntry);
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

