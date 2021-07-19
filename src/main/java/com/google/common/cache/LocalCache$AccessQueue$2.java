/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache$AccessQueue;
import com.google.common.cache.ReferenceEntry;
import com.google.common.collect.AbstractSequentialIterator;

public class LocalCache$AccessQueue$2
extends AbstractSequentialIterator {
    public final /* synthetic */ LocalCache$AccessQueue this$0;

    public LocalCache$AccessQueue$2(LocalCache$AccessQueue localCache$AccessQueue, ReferenceEntry referenceEntry) {
        this.this$0 = localCache$AccessQueue;
        super(referenceEntry);
    }

    public ReferenceEntry computeNext(ReferenceEntry referenceEntry) {
        ReferenceEntry referenceEntry2;
        if ((referenceEntry = referenceEntry.getNextInAccessQueue()) == (referenceEntry2 = this.this$0.head)) {
            referenceEntry = null;
        }
        return referenceEntry;
    }
}

