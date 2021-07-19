/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractSequentialIterator;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.RegularContiguousSet;

public class RegularContiguousSet$2
extends AbstractSequentialIterator {
    public final Comparable first;
    public final /* synthetic */ RegularContiguousSet this$0;

    public RegularContiguousSet$2(RegularContiguousSet object, Comparable comparable) {
        this.this$0 = object;
        super(comparable);
        this.first = object = ((RegularContiguousSet)object).first();
    }

    public Comparable computeNext(Comparable comparable) {
        Object object = this.first;
        boolean bl2 = RegularContiguousSet.access$000(comparable, (Comparable)object);
        if (bl2) {
            comparable = null;
        } else {
            object = this.this$0.domain;
            comparable = ((DiscreteDomain)object).previous(comparable);
        }
        return comparable;
    }
}

