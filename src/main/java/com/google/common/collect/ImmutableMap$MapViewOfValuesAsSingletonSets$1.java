/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableMap$MapViewOfValuesAsSingletonSets;
import com.google.common.collect.ImmutableMap$MapViewOfValuesAsSingletonSets$1$1;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;
import java.util.Map;

public class ImmutableMap$MapViewOfValuesAsSingletonSets$1
extends UnmodifiableIterator {
    public final /* synthetic */ ImmutableMap$MapViewOfValuesAsSingletonSets this$1;
    public final /* synthetic */ Iterator val$backingIterator;

    public ImmutableMap$MapViewOfValuesAsSingletonSets$1(ImmutableMap$MapViewOfValuesAsSingletonSets immutableMap$MapViewOfValuesAsSingletonSets, Iterator iterator2) {
        this.this$1 = immutableMap$MapViewOfValuesAsSingletonSets;
        this.val$backingIterator = iterator2;
    }

    public boolean hasNext() {
        return this.val$backingIterator.hasNext();
    }

    public Map.Entry next() {
        Map.Entry entry = (Map.Entry)this.val$backingIterator.next();
        ImmutableMap$MapViewOfValuesAsSingletonSets$1$1 immutableMap$MapViewOfValuesAsSingletonSets$1$1 = new ImmutableMap$MapViewOfValuesAsSingletonSets$1$1(this, entry);
        return immutableMap$MapViewOfValuesAsSingletonSets$1$1;
    }
}

