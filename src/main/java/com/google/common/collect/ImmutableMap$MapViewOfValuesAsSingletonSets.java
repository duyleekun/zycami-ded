/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap$1;
import com.google.common.collect.ImmutableMap$IteratorBasedImmutableMap;
import com.google.common.collect.ImmutableMap$MapViewOfValuesAsSingletonSets$1;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;

public final class ImmutableMap$MapViewOfValuesAsSingletonSets
extends ImmutableMap$IteratorBasedImmutableMap {
    public final /* synthetic */ ImmutableMap this$0;

    private ImmutableMap$MapViewOfValuesAsSingletonSets(ImmutableMap immutableMap) {
        this.this$0 = immutableMap;
    }

    public /* synthetic */ ImmutableMap$MapViewOfValuesAsSingletonSets(ImmutableMap immutableMap, ImmutableMap$1 immutableMap$1) {
        this(immutableMap);
    }

    public boolean containsKey(Object object) {
        return this.this$0.containsKey(object);
    }

    public ImmutableSet createKeySet() {
        return this.this$0.keySet();
    }

    public UnmodifiableIterator entryIterator() {
        UnmodifiableIterator unmodifiableIterator = this.this$0.entrySet().iterator();
        ImmutableMap$MapViewOfValuesAsSingletonSets$1 immutableMap$MapViewOfValuesAsSingletonSets$1 = new ImmutableMap$MapViewOfValuesAsSingletonSets$1(this, unmodifiableIterator);
        return immutableMap$MapViewOfValuesAsSingletonSets$1;
    }

    public ImmutableSet get(Object object) {
        ImmutableMap immutableMap = this.this$0;
        object = (object = immutableMap.get(object)) == null ? null : ImmutableSet.of(object);
        return object;
    }

    public int hashCode() {
        return this.this$0.hashCode();
    }

    public boolean isHashCodeFast() {
        return this.this$0.isHashCodeFast();
    }

    public boolean isPartialView() {
        return this.this$0.isPartialView();
    }

    public int size() {
        return this.this$0.size();
    }
}

