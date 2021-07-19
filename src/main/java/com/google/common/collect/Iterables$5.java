/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterators;
import java.util.Iterator;

public final class Iterables$5
extends FluentIterable {
    public final /* synthetic */ Iterable val$fromIterable;
    public final /* synthetic */ Function val$function;

    public Iterables$5(Iterable iterable, Function function) {
        this.val$fromIterable = iterable;
        this.val$function = function;
    }

    public Iterator iterator() {
        Iterator iterator2 = this.val$fromIterable.iterator();
        Function function = this.val$function;
        return Iterators.transform(iterator2, function);
    }
}

