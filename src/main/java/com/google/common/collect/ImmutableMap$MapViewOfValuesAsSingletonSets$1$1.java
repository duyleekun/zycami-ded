/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapEntry;
import com.google.common.collect.ImmutableMap$MapViewOfValuesAsSingletonSets$1;
import com.google.common.collect.ImmutableSet;
import java.util.Map;

public class ImmutableMap$MapViewOfValuesAsSingletonSets$1$1
extends AbstractMapEntry {
    public final /* synthetic */ ImmutableMap$MapViewOfValuesAsSingletonSets.1 this$2;
    public final /* synthetic */ Map.Entry val$backingEntry;

    public ImmutableMap$MapViewOfValuesAsSingletonSets$1$1(ImmutableMap$MapViewOfValuesAsSingletonSets.1 var1_1, Map.Entry entry) {
        this.this$2 = var1_1;
        this.val$backingEntry = entry;
    }

    public Object getKey() {
        return this.val$backingEntry.getKey();
    }

    public ImmutableSet getValue() {
        return ImmutableSet.of(this.val$backingEntry.getValue());
    }
}

