/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.DenseImmutableTable$ImmutableArrayMap;
import com.google.common.collect.Maps;
import java.util.Map;

public class DenseImmutableTable$ImmutableArrayMap$1
extends AbstractIterator {
    private int index = -1;
    private final int maxIndex;
    public final /* synthetic */ DenseImmutableTable$ImmutableArrayMap this$0;

    public DenseImmutableTable$ImmutableArrayMap$1(DenseImmutableTable$ImmutableArrayMap denseImmutableTable$ImmutableArrayMap) {
        int n10;
        this.this$0 = denseImmutableTable$ImmutableArrayMap;
        this.maxIndex = n10 = denseImmutableTable$ImmutableArrayMap.keyToIndex().size();
    }

    public Map.Entry computeNext() {
        int n10;
        int n11 = this.index;
        while ((n11 = (this.index = ++n11)) < (n10 = this.maxIndex)) {
            DenseImmutableTable$ImmutableArrayMap denseImmutableTable$ImmutableArrayMap = this.this$0;
            Object object = denseImmutableTable$ImmutableArrayMap.getValue(n11);
            if (object != null) {
                denseImmutableTable$ImmutableArrayMap = this.this$0;
                int n12 = this.index;
                return Maps.immutableEntry(denseImmutableTable$ImmutableArrayMap.getKey(n12), object);
            }
            n11 = this.index;
        }
        return (Map.Entry)this.endOfData();
    }
}

