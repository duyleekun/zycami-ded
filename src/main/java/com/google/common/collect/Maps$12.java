/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapEntry;
import com.google.common.collect.Maps$EntryTransformer;
import java.util.Map;

public final class Maps$12
extends AbstractMapEntry {
    public final /* synthetic */ Map.Entry val$entry;
    public final /* synthetic */ Maps$EntryTransformer val$transformer;

    public Maps$12(Map.Entry entry, Maps$EntryTransformer maps$EntryTransformer) {
        this.val$entry = entry;
        this.val$transformer = maps$EntryTransformer;
    }

    public Object getKey() {
        return this.val$entry.getKey();
    }

    public Object getValue() {
        Maps$EntryTransformer maps$EntryTransformer = this.val$transformer;
        Object k10 = this.val$entry.getKey();
        Object v10 = this.val$entry.getValue();
        return maps$EntryTransformer.transformEntry(k10, v10);
    }
}

