/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.FluentIterable$3$1;
import com.google.common.collect.Iterators;
import java.util.Iterator;

public final class FluentIterable$3
extends FluentIterable {
    public final /* synthetic */ Iterable[] val$inputs;

    public FluentIterable$3(Iterable[] iterableArray) {
        this.val$inputs = iterableArray;
    }

    public Iterator iterator() {
        int n10 = this.val$inputs.length;
        FluentIterable$3$1 fluentIterable$3$1 = new FluentIterable$3$1(this, n10);
        return Iterators.concat((Iterator)fluentIterable$3$1);
    }
}

