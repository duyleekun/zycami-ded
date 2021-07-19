/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.CollectionFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class CollectionFuture$ListFuture
extends CollectionFuture {
    public CollectionFuture$ListFuture(ImmutableCollection immutableCollection, boolean bl2) {
        super(immutableCollection, bl2);
        this.init();
    }

    public List combine(List object) {
        boolean bl2;
        int n10 = object.size();
        ArrayList arrayList = Lists.newArrayListWithCapacity(n10);
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = (Optional)object.next();
            if (object2 != null) {
                object2 = ((Optional)object2).orNull();
            } else {
                bl2 = false;
                object2 = null;
            }
            arrayList.add(object2);
        }
        return Collections.unmodifiableList(arrayList);
    }
}

