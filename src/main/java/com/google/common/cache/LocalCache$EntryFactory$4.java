/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache$EntryFactory;
import com.google.common.cache.LocalCache$Segment;
import com.google.common.cache.LocalCache$StrongAccessWriteEntry;
import com.google.common.cache.ReferenceEntry;

public final class LocalCache$EntryFactory$4
extends LocalCache$EntryFactory {
    public ReferenceEntry copyEntry(LocalCache$Segment object, ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2) {
        object = super.copyEntry((LocalCache$Segment)object, referenceEntry, referenceEntry2);
        this.copyAccessEntry(referenceEntry, (ReferenceEntry)object);
        this.copyWriteEntry(referenceEntry, (ReferenceEntry)object);
        return object;
    }

    public ReferenceEntry newEntry(LocalCache$Segment object, Object object2, int n10, ReferenceEntry referenceEntry) {
        object = new LocalCache$StrongAccessWriteEntry(object2, n10, referenceEntry);
        return object;
    }
}

