/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

public class FilteredKeyMultimap$AddRejectingSet
extends ForwardingSet {
    public final Object key;

    public FilteredKeyMultimap$AddRejectingSet(Object object) {
        this.key = object;
    }

    public boolean add(Object object) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Key does not satisfy predicate: ");
        Object object2 = this.key;
        charSequence.append(object2);
        charSequence = charSequence.toString();
        object = new IllegalArgumentException((String)charSequence);
        throw object;
    }

    public boolean addAll(Collection object) {
        Preconditions.checkNotNull(object);
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Key does not satisfy predicate: ");
        Object object2 = this.key;
        charSequence.append(object2);
        charSequence = charSequence.toString();
        object = new IllegalArgumentException((String)charSequence);
        throw object;
    }

    public Set delegate() {
        return Collections.emptySet();
    }
}

