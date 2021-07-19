/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimaps$UnmodifiableMultimap;
import java.util.Collections;
import java.util.List;

public class Multimaps$UnmodifiableListMultimap
extends Multimaps$UnmodifiableMultimap
implements ListMultimap {
    private static final long serialVersionUID;

    public Multimaps$UnmodifiableListMultimap(ListMultimap listMultimap) {
        super(listMultimap);
    }

    public ListMultimap delegate() {
        return (ListMultimap)super.delegate();
    }

    public List get(Object object) {
        return Collections.unmodifiableList(this.delegate().get(object));
    }

    public List removeAll(Object object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public List replaceValues(Object object, Iterable iterable) {
        object = new UnsupportedOperationException();
        throw object;
    }
}

