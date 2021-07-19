/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableRangeSet;
import com.google.common.collect.Range;
import java.io.Serializable;

public final class ImmutableRangeSet$SerializedForm
implements Serializable {
    private final ImmutableList ranges;

    public ImmutableRangeSet$SerializedForm(ImmutableList immutableList) {
        this.ranges = immutableList;
    }

    public Object readResolve() {
        Serializable serializable = this.ranges;
        boolean bl2 = serializable.isEmpty();
        if (bl2) {
            return ImmutableRangeSet.of();
        }
        serializable = this.ranges;
        ImmutableList immutableList = ImmutableList.of(Range.all());
        bl2 = serializable.equals(immutableList);
        if (bl2) {
            return ImmutableRangeSet.all();
        }
        immutableList = this.ranges;
        serializable = new ImmutableRangeSet(immutableList);
        return serializable;
    }
}

