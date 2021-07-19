/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap$SerializedForm;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.ImmutableSortedMap$Builder;
import java.util.Comparator;

public class ImmutableSortedMap$SerializedForm
extends ImmutableMap$SerializedForm {
    private static final long serialVersionUID;
    private final Comparator comparator;

    public ImmutableSortedMap$SerializedForm(ImmutableSortedMap object) {
        super((ImmutableMap)object);
        this.comparator = object = ((ImmutableSortedMap)object).comparator();
    }

    public Object readResolve() {
        Comparator comparator = this.comparator;
        ImmutableSortedMap$Builder immutableSortedMap$Builder = new ImmutableSortedMap$Builder(comparator);
        return this.createMap(immutableSortedMap$Builder);
    }
}

