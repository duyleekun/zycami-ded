/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables$6$1;
import com.google.common.collect.Iterators;
import java.util.Iterator;
import java.util.List;

public final class Iterables$6
extends FluentIterable {
    public final /* synthetic */ Iterable val$iterable;
    public final /* synthetic */ int val$numberToSkip;

    public Iterables$6(Iterable iterable, int n10) {
        this.val$iterable = iterable;
        this.val$numberToSkip = n10;
    }

    public Iterator iterator() {
        Object object = this.val$iterable;
        int n10 = object instanceof List;
        if (n10 != 0) {
            object = (List)object;
            n10 = object.size();
            int n11 = this.val$numberToSkip;
            n10 = Math.min(n10, n11);
            n11 = object.size();
            return object.subList(n10, n11).iterator();
        }
        object = object.iterator();
        n10 = this.val$numberToSkip;
        Iterators.advance((Iterator)object, n10);
        Iterables$6$1 iterables$6$1 = new Iterables$6$1(this, (Iterator)object);
        return iterables$6$1;
    }
}

