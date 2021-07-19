/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache$EntryFactory;
import com.google.common.cache.LocalCache$Segment;
import com.google.common.cache.LocalCache$StrongEntry;
import com.google.common.cache.ReferenceEntry;

public final class LocalCache$EntryFactory$1
extends LocalCache$EntryFactory {
    public ReferenceEntry newEntry(LocalCache$Segment object, Object object2, int n10, ReferenceEntry referenceEntry) {
        object = new LocalCache$StrongEntry(object2, n10, referenceEntry);
        return object;
    }
}

