/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterators;
import java.util.Iterator;

public final class Iterables$4
extends FluentIterable {
    public final /* synthetic */ Predicate val$retainIfTrue;
    public final /* synthetic */ Iterable val$unfiltered;

    public Iterables$4(Iterable iterable, Predicate predicate) {
        this.val$unfiltered = iterable;
        this.val$retainIfTrue = predicate;
    }

    public Iterator iterator() {
        Iterator iterator2 = this.val$unfiltered.iterator();
        Predicate predicate = this.val$retainIfTrue;
        return Iterators.filter(iterator2, predicate);
    }
}

