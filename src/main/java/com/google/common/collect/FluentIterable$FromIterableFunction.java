/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;

public class FluentIterable$FromIterableFunction
implements Function {
    private FluentIterable$FromIterableFunction() {
    }

    public FluentIterable apply(Iterable iterable) {
        return FluentIterable.from(iterable);
    }
}

