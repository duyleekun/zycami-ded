/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.ImmutableAsList;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.RegularContiguousSet;

public class RegularContiguousSet$3
extends ImmutableAsList {
    public final /* synthetic */ RegularContiguousSet this$0;

    public RegularContiguousSet$3(RegularContiguousSet regularContiguousSet) {
        this.this$0 = regularContiguousSet;
    }

    public ImmutableSortedSet delegateCollection() {
        return this.this$0;
    }

    public Comparable get(int n10) {
        int n11 = this.size();
        Preconditions.checkElementIndex(n10, n11);
        Object object = this.this$0;
        DiscreteDomain discreteDomain = ((ContiguousSet)object).domain;
        object = ((RegularContiguousSet)object).first();
        long l10 = n10;
        return discreteDomain.offset((Comparable)object, l10);
    }
}

