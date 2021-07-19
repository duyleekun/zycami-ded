/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ForwardingMapEntry;
import com.google.common.collect.Synchronized;
import com.google.common.collect.Synchronized$SynchronizedAsMapEntries$1;
import java.util.Collection;
import java.util.Map;

public class Synchronized$SynchronizedAsMapEntries$1$1
extends ForwardingMapEntry {
    public final /* synthetic */ Synchronized$SynchronizedAsMapEntries$1 this$1;
    public final /* synthetic */ Map.Entry val$entry;

    public Synchronized$SynchronizedAsMapEntries$1$1(Synchronized$SynchronizedAsMapEntries$1 synchronized$SynchronizedAsMapEntries$1, Map.Entry entry) {
        this.this$1 = synchronized$SynchronizedAsMapEntries$1;
        this.val$entry = entry;
    }

    public Map.Entry delegate() {
        return this.val$entry;
    }

    public Collection getValue() {
        Collection collection = (Collection)this.val$entry.getValue();
        Object object = this.this$1.this$0.mutex;
        return Synchronized.access$400(collection, object);
    }
}

