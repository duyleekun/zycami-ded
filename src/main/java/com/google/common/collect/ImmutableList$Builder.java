/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableCollection$ArrayBasedBuilder;
import com.google.common.collect.ImmutableList;
import java.util.Iterator;

public final class ImmutableList$Builder
extends ImmutableCollection$ArrayBasedBuilder {
    public ImmutableList$Builder() {
        this(4);
    }

    public ImmutableList$Builder(int n10) {
        super(n10);
    }

    public ImmutableList$Builder add(Object object) {
        super.add(object);
        return this;
    }

    public ImmutableList$Builder add(Object ... objectArray) {
        super.add(objectArray);
        return this;
    }

    public ImmutableList$Builder addAll(Iterable iterable) {
        super.addAll(iterable);
        return this;
    }

    public ImmutableList$Builder addAll(Iterator iterator2) {
        super.addAll(iterator2);
        return this;
    }

    public ImmutableList build() {
        this.forceCopy = true;
        Object[] objectArray = this.contents;
        int n10 = this.size;
        return ImmutableList.asImmutableList(objectArray, n10);
    }
}

