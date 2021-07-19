/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.BaseImmutableMultimap;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap$1;
import com.google.common.collect.ImmutableMultimap$2;
import com.google.common.collect.ImmutableMultimap$Builder;
import com.google.common.collect.ImmutableMultimap$EntryCollection;
import com.google.common.collect.ImmutableMultimap$Keys;
import com.google.common.collect.ImmutableMultimap$Values;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;
import com.google.common.collect.UnmodifiableIterator;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;

public abstract class ImmutableMultimap
extends BaseImmutableMultimap
implements Serializable {
    private static final long serialVersionUID;
    public final transient ImmutableMap map;
    public final transient int size;

    public ImmutableMultimap(ImmutableMap immutableMap, int n10) {
        this.map = immutableMap;
        this.size = n10;
    }

    public static ImmutableMultimap$Builder builder() {
        ImmutableMultimap$Builder immutableMultimap$Builder = new ImmutableMultimap$Builder();
        return immutableMultimap$Builder;
    }

    public static ImmutableMultimap copyOf(Multimap multimap) {
        boolean bl2 = multimap instanceof ImmutableMultimap;
        if (bl2) {
            Multimap multimap2 = multimap;
            multimap2 = (ImmutableMultimap)multimap;
            boolean bl3 = ((ImmutableMultimap)multimap2).isPartialView();
            if (!bl3) {
                return multimap2;
            }
        }
        return ImmutableListMultimap.copyOf(multimap);
    }

    public static ImmutableMultimap copyOf(Iterable iterable) {
        return ImmutableListMultimap.copyOf(iterable);
    }

    public static ImmutableMultimap of() {
        return ImmutableListMultimap.of();
    }

    public static ImmutableMultimap of(Object object, Object object2) {
        return ImmutableListMultimap.of(object, object2);
    }

    public static ImmutableMultimap of(Object object, Object object2, Object object3, Object object4) {
        return ImmutableListMultimap.of(object, object2, object3, object4);
    }

    public static ImmutableMultimap of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6) {
        return ImmutableListMultimap.of(object, object2, object3, object4, object5, object6);
    }

    public static ImmutableMultimap of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8) {
        return ImmutableListMultimap.of(object, object2, object3, object4, object5, object6, object7, object8);
    }

    public static ImmutableMultimap of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10) {
        return ImmutableListMultimap.of(object, object2, object3, object4, object5, object6, object7, object8, object9, object10);
    }

    public ImmutableMap asMap() {
        return this.map;
    }

    public void clear() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public boolean containsKey(Object object) {
        return this.map.containsKey(object);
    }

    public boolean containsValue(Object object) {
        boolean bl2;
        if (object != null && (bl2 = super.containsValue(object))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public Map createAsMap() {
        AssertionError assertionError = new AssertionError((Object)"should never be called");
        throw assertionError;
    }

    public ImmutableCollection createEntries() {
        ImmutableMultimap$EntryCollection immutableMultimap$EntryCollection = new ImmutableMultimap$EntryCollection(this);
        return immutableMultimap$EntryCollection;
    }

    public Set createKeySet() {
        AssertionError assertionError = new AssertionError((Object)"unreachable");
        throw assertionError;
    }

    public ImmutableMultiset createKeys() {
        ImmutableMultimap$Keys immutableMultimap$Keys = new ImmutableMultimap$Keys(this);
        return immutableMultimap$Keys;
    }

    public ImmutableCollection createValues() {
        ImmutableMultimap$Values immutableMultimap$Values = new ImmutableMultimap$Values(this);
        return immutableMultimap$Values;
    }

    public ImmutableCollection entries() {
        return (ImmutableCollection)super.entries();
    }

    public UnmodifiableIterator entryIterator() {
        ImmutableMultimap$1 immutableMultimap$1 = new ImmutableMultimap$1(this);
        return immutableMultimap$1;
    }

    public abstract ImmutableCollection get(Object var1);

    public abstract ImmutableMultimap inverse();

    public boolean isPartialView() {
        return this.map.isPartialView();
    }

    public ImmutableSet keySet() {
        return this.map.keySet();
    }

    public ImmutableMultiset keys() {
        return (ImmutableMultiset)super.keys();
    }

    public boolean put(Object object, Object object2) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public boolean putAll(Multimap object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public boolean putAll(Object object, Iterable iterable) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public boolean remove(Object object, Object object2) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public ImmutableCollection removeAll(Object object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public ImmutableCollection replaceValues(Object object, Iterable iterable) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public int size() {
        return this.size;
    }

    public UnmodifiableIterator valueIterator() {
        ImmutableMultimap$2 immutableMultimap$2 = new ImmutableMultimap$2(this);
        return immutableMultimap$2;
    }

    public ImmutableCollection values() {
        return (ImmutableCollection)super.values();
    }
}

