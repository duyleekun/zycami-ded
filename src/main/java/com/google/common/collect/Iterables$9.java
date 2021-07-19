/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import java.util.Comparator;
import java.util.Iterator;

public final class Iterables$9
extends FluentIterable {
    public final /* synthetic */ Comparator val$comparator;
    public final /* synthetic */ Iterable val$iterables;

    public Iterables$9(Iterable iterable, Comparator comparator) {
        this.val$iterables = iterable;
        this.val$comparator = comparator;
    }

    public Iterator iterator() {
        Iterable iterable = this.val$iterables;
        Object object = Iterables.toIterator();
        iterable = Iterables.transform(iterable, (Function)object);
        object = this.val$comparator;
        return Iterators.mergeSorted(iterable, (Comparator)object);
    }
}

