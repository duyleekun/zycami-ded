/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableEnumMap$1;
import com.google.common.collect.ImmutableEnumMap$EnumSerializedForm;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap$IteratorBasedImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.UnmodifiableIterator;
import java.util.EnumMap;
import java.util.Map;

public final class ImmutableEnumMap
extends ImmutableMap$IteratorBasedImmutableMap {
    private final transient EnumMap delegate;

    private ImmutableEnumMap(EnumMap enumMap) {
        this.delegate = enumMap;
        Preconditions.checkArgument(enumMap.isEmpty() ^ true);
    }

    public /* synthetic */ ImmutableEnumMap(EnumMap enumMap, ImmutableEnumMap$1 immutableEnumMap$1) {
        this(enumMap);
    }

    public static ImmutableMap asImmutable(EnumMap object) {
        int n10 = ((EnumMap)object).size();
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                ImmutableEnumMap immutableEnumMap = new ImmutableEnumMap((EnumMap)object);
                return immutableEnumMap;
            }
            object = (Map.Entry)Iterables.getOnlyElement(((EnumMap)object).entrySet());
            Object k10 = object.getKey();
            object = object.getValue();
            return ImmutableMap.of(k10, object);
        }
        return ImmutableMap.of();
    }

    public boolean containsKey(Object object) {
        return this.delegate.containsKey(object);
    }

    public UnmodifiableIterator entryIterator() {
        return Maps.unmodifiableEntryIterator(this.delegate.entrySet().iterator());
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        boolean bl2 = object instanceof ImmutableEnumMap;
        if (bl2) {
            object = ((ImmutableEnumMap)object).delegate;
        }
        return this.delegate.equals(object);
    }

    public Object get(Object object) {
        return this.delegate.get(object);
    }

    public boolean isPartialView() {
        return false;
    }

    public UnmodifiableIterator keyIterator() {
        return Iterators.unmodifiableIterator(this.delegate.keySet().iterator());
    }

    public int size() {
        return this.delegate.size();
    }

    public Object writeReplace() {
        EnumMap enumMap = this.delegate;
        ImmutableEnumMap$EnumSerializedForm immutableEnumMap$EnumSerializedForm = new ImmutableEnumMap$EnumSerializedForm(enumMap);
        return immutableEnumMap$EnumSerializedForm;
    }
}

