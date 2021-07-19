/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterators;
import java.util.Iterator;

public final class Iterables$7
extends FluentIterable {
    public final /* synthetic */ Iterable val$iterable;
    public final /* synthetic */ int val$limitSize;

    public Iterables$7(Iterable iterable, int n10) {
        this.val$iterable = iterable;
        this.val$limitSize = n10;
    }

    public Iterator iterator() {
        Iterator iterator2 = this.val$iterable.iterator();
        int n10 = this.val$limitSize;
        return Iterators.limit(iterator2, n10);
    }
}

