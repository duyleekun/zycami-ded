/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps$UnmodifiableMultimap;
import com.google.common.collect.SetMultimap;
import java.util.Collections;
import java.util.Set;

public class Multimaps$UnmodifiableSetMultimap
extends Multimaps$UnmodifiableMultimap
implements SetMultimap {
    private static final long serialVersionUID;

    public Multimaps$UnmodifiableSetMultimap(SetMultimap setMultimap) {
        super(setMultimap);
    }

    public SetMultimap delegate() {
        return (SetMultimap)super.delegate();
    }

    public Set entries() {
        return Maps.unmodifiableEntrySet(this.delegate().entries());
    }

    public Set get(Object object) {
        return Collections.unmodifiableSet(this.delegate().get(object));
    }

    public Set removeAll(Object object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public Set replaceValues(Object object, Iterable iterable) {
        object = new UnsupportedOperationException();
        throw object;
    }
}

