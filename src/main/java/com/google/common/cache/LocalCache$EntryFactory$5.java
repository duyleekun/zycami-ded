/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache$EntryFactory;
import com.google.common.cache.LocalCache$Segment;
import com.google.common.cache.LocalCache$WeakEntry;
import com.google.common.cache.ReferenceEntry;
import java.lang.ref.ReferenceQueue;

public final class LocalCache$EntryFactory$5
extends LocalCache$EntryFactory {
    public ReferenceEntry newEntry(LocalCache$Segment object, Object object2, int n10, ReferenceEntry referenceEntry) {
        object = ((LocalCache$Segment)object).keyReferenceQueue;
        LocalCache$WeakEntry localCache$WeakEntry = new LocalCache$WeakEntry((ReferenceQueue)object, object2, n10, referenceEntry);
        return localCache$WeakEntry;
    }
}

