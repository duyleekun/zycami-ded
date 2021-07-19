/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ForwardingCollection;
import com.google.common.collect.Sets;
import com.google.common.collect.TreeRangeSet;
import java.util.Collection;
import java.util.Set;

public final class TreeRangeSet$AsRanges
extends ForwardingCollection
implements Set {
    public final Collection delegate;
    public final /* synthetic */ TreeRangeSet this$0;

    public TreeRangeSet$AsRanges(TreeRangeSet treeRangeSet, Collection collection) {
        this.this$0 = treeRangeSet;
        this.delegate = collection;
    }

    public Collection delegate() {
        return this.delegate;
    }

    public boolean equals(Object object) {
        return Sets.equalsImpl(this, object);
    }

    public int hashCode() {
        return Sets.hashCodeImpl(this);
    }
}

