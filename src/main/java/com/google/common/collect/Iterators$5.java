/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.AbstractIterator;
import java.util.Iterator;

public final class Iterators$5
extends AbstractIterator {
    public final /* synthetic */ Predicate val$retainIfTrue;
    public final /* synthetic */ Iterator val$unfiltered;

    public Iterators$5(Iterator iterator2, Predicate predicate) {
        this.val$unfiltered = iterator2;
        this.val$retainIfTrue = predicate;
    }

    public Object computeNext() {
        Iterator iterator2;
        boolean bl2;
        while (bl2 = (iterator2 = this.val$unfiltered).hasNext()) {
            Predicate predicate = this.val$retainIfTrue;
            iterator2 = this.val$unfiltered.next();
            boolean bl3 = predicate.apply(iterator2);
            if (!bl3) continue;
            return iterator2;
        }
        return this.endOfData();
    }
}

