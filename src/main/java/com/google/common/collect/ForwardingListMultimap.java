/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ForwardingMultimap;
import com.google.common.collect.ListMultimap;
import java.util.List;

public abstract class ForwardingListMultimap
extends ForwardingMultimap
implements ListMultimap {
    public abstract ListMultimap delegate();

    public List get(Object object) {
        return this.delegate().get(object);
    }

    public List removeAll(Object object) {
        return this.delegate().removeAll(object);
    }

    public List replaceValues(Object object, Iterable iterable) {
        return this.delegate().replaceValues(object, iterable);
    }
}

