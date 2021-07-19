/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ForwardingMultimap;
import com.google.common.collect.SetMultimap;
import java.util.Set;

public abstract class ForwardingSetMultimap
extends ForwardingMultimap
implements SetMultimap {
    public abstract SetMultimap delegate();

    public Set entries() {
        return this.delegate().entries();
    }

    public Set get(Object object) {
        return this.delegate().get(object);
    }

    public Set removeAll(Object object) {
        return this.delegate().removeAll(object);
    }

    public Set replaceValues(Object object, Iterable iterable) {
        return this.delegate().replaceValues(object, iterable);
    }
}

