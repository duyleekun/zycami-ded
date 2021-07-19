/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache$AbstractReferenceEntry;
import com.google.common.cache.LocalCache$AccessQueue;
import com.google.common.cache.ReferenceEntry;

public class LocalCache$AccessQueue$1
extends LocalCache$AbstractReferenceEntry {
    public ReferenceEntry nextAccess = this;
    public ReferenceEntry previousAccess = this;
    public final /* synthetic */ LocalCache$AccessQueue this$0;

    public LocalCache$AccessQueue$1(LocalCache$AccessQueue localCache$AccessQueue) {
        this.this$0 = localCache$AccessQueue;
    }

    public long getAccessTime() {
        return Long.MAX_VALUE;
    }

    public ReferenceEntry getNextInAccessQueue() {
        return this.nextAccess;
    }

    public ReferenceEntry getPreviousInAccessQueue() {
        return this.previousAccess;
    }

    public void setAccessTime(long l10) {
    }

    public void setNextInAccessQueue(ReferenceEntry referenceEntry) {
        this.nextAccess = referenceEntry;
    }

    public void setPreviousInAccessQueue(ReferenceEntry referenceEntry) {
        this.previousAccess = referenceEntry;
    }
}

