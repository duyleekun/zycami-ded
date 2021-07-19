/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableRangeMap;
import com.google.common.collect.ImmutableRangeMap$Builder;
import com.google.common.collect.Range;
import com.google.common.collect.UnmodifiableIterator;
import java.io.Serializable;
import java.util.Map;

public class ImmutableRangeMap$SerializedForm
implements Serializable {
    private static final long serialVersionUID;
    private final ImmutableMap mapOfRanges;

    public ImmutableRangeMap$SerializedForm(ImmutableMap immutableMap) {
        this.mapOfRanges = immutableMap;
    }

    public Object createRangeMap() {
        boolean bl2;
        ImmutableRangeMap$Builder immutableRangeMap$Builder = new ImmutableRangeMap$Builder();
        UnmodifiableIterator unmodifiableIterator = this.mapOfRanges.entrySet().iterator();
        while (bl2 = unmodifiableIterator.hasNext()) {
            Map.Entry entry = (Map.Entry)unmodifiableIterator.next();
            Range range = (Range)entry.getKey();
            entry = entry.getValue();
            immutableRangeMap$Builder.put(range, entry);
        }
        return immutableRangeMap$Builder.build();
    }

    public Object readResolve() {
        ImmutableMap immutableMap = this.mapOfRanges;
        boolean bl2 = immutableMap.isEmpty();
        if (bl2) {
            return ImmutableRangeMap.of();
        }
        return this.createRangeMap();
    }
}

