/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import java.util.Iterator;

public final class FluentIterable$2
extends FluentIterable {
    public final /* synthetic */ Iterable val$inputs;

    public FluentIterable$2(Iterable iterable) {
        this.val$inputs = iterable;
    }

    public Iterator iterator() {
        Iterator iterator2 = this.val$inputs.iterator();
        Function function = Iterables.toIterator();
        return Iterators.concat(Iterators.transform(iterator2, function));
    }
}

