/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterators;
import java.util.Iterator;

public final class Iterables$1
extends FluentIterable {
    public final /* synthetic */ Iterable val$iterable;

    public Iterables$1(Iterable iterable) {
        this.val$iterable = iterable;
    }

    public Iterator iterator() {
        return Iterators.cycle(this.val$iterable);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = this.val$iterable.toString();
        stringBuilder.append(string2);
        stringBuilder.append(" (cycled)");
        return stringBuilder.toString();
    }
}

