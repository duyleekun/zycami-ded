/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingMapEntry;
import com.google.common.collect.Iterators;
import com.google.common.reflect.MutableTypeToInstanceMap$1;
import com.google.common.reflect.MutableTypeToInstanceMap$UnmodifiableEntry$1;
import com.google.common.reflect.MutableTypeToInstanceMap$UnmodifiableEntry$2;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class MutableTypeToInstanceMap$UnmodifiableEntry
extends ForwardingMapEntry {
    private final Map.Entry delegate;

    private MutableTypeToInstanceMap$UnmodifiableEntry(Map.Entry entry) {
        this.delegate = entry = (Map.Entry)Preconditions.checkNotNull(entry);
    }

    public /* synthetic */ MutableTypeToInstanceMap$UnmodifiableEntry(Map.Entry entry, MutableTypeToInstanceMap$1 mutableTypeToInstanceMap$1) {
        this(entry);
    }

    public static /* synthetic */ Iterator access$000(Iterator iterator2) {
        return MutableTypeToInstanceMap$UnmodifiableEntry.transformEntries(iterator2);
    }

    private static Iterator transformEntries(Iterator iterator2) {
        MutableTypeToInstanceMap$UnmodifiableEntry$2 mutableTypeToInstanceMap$UnmodifiableEntry$2 = new MutableTypeToInstanceMap$UnmodifiableEntry$2();
        return Iterators.transform(iterator2, mutableTypeToInstanceMap$UnmodifiableEntry$2);
    }

    public static Set transformEntries(Set set) {
        MutableTypeToInstanceMap$UnmodifiableEntry$1 mutableTypeToInstanceMap$UnmodifiableEntry$1 = new MutableTypeToInstanceMap$UnmodifiableEntry$1(set);
        return mutableTypeToInstanceMap$UnmodifiableEntry$1;
    }

    public Map.Entry delegate() {
        return this.delegate;
    }

    public Object setValue(Object object) {
        object = new UnsupportedOperationException();
        throw object;
    }
}

