/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.AggregateFuture;
import com.google.common.util.concurrent.AggregateFuture$ReleaseResourcesReason;
import java.util.AbstractCollection;
import java.util.List;

public abstract class CollectionFuture
extends AggregateFuture {
    private List values;

    public CollectionFuture(ImmutableCollection immutableCollection, boolean n10) {
        AbstractCollection abstractCollection;
        int n11 = 1;
        super(immutableCollection, n10 != 0, n11 != 0);
        n10 = immutableCollection.isEmpty();
        if (n10 != 0) {
            abstractCollection = ImmutableList.of();
        } else {
            n10 = immutableCollection.size();
            abstractCollection = Lists.newArrayListWithCapacity(n10);
        }
        this.values = abstractCollection;
        abstractCollection = null;
        for (n10 = 0; n10 < (n11 = immutableCollection.size()); ++n10) {
            List list = this.values;
            list.add(null);
        }
    }

    public final void collectOneValue(int n10, Object object) {
        List list = this.values;
        if (list != null) {
            object = Optional.fromNullable(object);
            list.set(n10, object);
        }
    }

    public abstract Object combine(List var1);

    public final void handleAllCompleted() {
        Object object = this.values;
        if (object != null) {
            object = this.combine((List)object);
            this.set(object);
        }
    }

    public void releaseResources(AggregateFuture$ReleaseResourcesReason aggregateFuture$ReleaseResourcesReason) {
        super.releaseResources(aggregateFuture$ReleaseResourcesReason);
        this.values = null;
    }
}

