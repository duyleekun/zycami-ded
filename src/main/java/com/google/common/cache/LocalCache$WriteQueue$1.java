/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache$AbstractReferenceEntry;
import com.google.common.cache.LocalCache$WriteQueue;
import com.google.common.cache.ReferenceEntry;

public class LocalCache$WriteQueue$1
extends LocalCache$AbstractReferenceEntry {
    public ReferenceEntry nextWrite = this;
    public ReferenceEntry previousWrite = this;
    public final /* synthetic */ LocalCache$WriteQueue this$0;

    public LocalCache$WriteQueue$1(LocalCache$WriteQueue localCache$WriteQueue) {
        this.this$0 = localCache$WriteQueue;
    }

    public ReferenceEntry getNextInWriteQueue() {
        return this.nextWrite;
    }

    public ReferenceEntry getPreviousInWriteQueue() {
        return this.previousWrite;
    }

    public long getWriteTime() {
        return Long.MAX_VALUE;
    }

    public void setNextInWriteQueue(ReferenceEntry referenceEntry) {
        this.nextWrite = referenceEntry;
    }

    public void setPreviousInWriteQueue(ReferenceEntry referenceEntry) {
        this.previousWrite = referenceEntry;
    }

    public void setWriteTime(long l10) {
    }
}

