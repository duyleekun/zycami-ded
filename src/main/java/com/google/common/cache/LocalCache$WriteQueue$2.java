/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache$WriteQueue;
import com.google.common.cache.ReferenceEntry;
import com.google.common.collect.AbstractSequentialIterator;

public class LocalCache$WriteQueue$2
extends AbstractSequentialIterator {
    public final /* synthetic */ LocalCache$WriteQueue this$0;

    public LocalCache$WriteQueue$2(LocalCache$WriteQueue localCache$WriteQueue, ReferenceEntry referenceEntry) {
        this.this$0 = localCache$WriteQueue;
        super(referenceEntry);
    }

    public ReferenceEntry computeNext(ReferenceEntry referenceEntry) {
        ReferenceEntry referenceEntry2;
        if ((referenceEntry = referenceEntry.getNextInWriteQueue()) == (referenceEntry2 = this.this$0.head)) {
            referenceEntry = null;
        }
        return referenceEntry;
    }
}

