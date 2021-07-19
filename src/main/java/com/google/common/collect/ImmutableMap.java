/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap$1;
import com.google.common.collect.ImmutableMap$Builder;
import com.google.common.collect.ImmutableMap$MapViewOfValuesAsSingletonSets;
import com.google.common.collect.ImmutableMap$SerializedForm;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableMap;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.SortedMap;

public abstract class ImmutableMap
implements Map,
Serializable {
    public static final Map.Entry[] EMPTY_ENTRY_ARRAY = new Map.Entry[0];
    private transient ImmutableSet entrySet;
    private transient ImmutableSet keySet;
    private transient ImmutableSetMultimap multimapView;
    private transient ImmutableCollection values;

    public static ImmutableMap$Builder builder() {
        ImmutableMap$Builder immutableMap$Builder = new ImmutableMap$Builder();
        return immutableMap$Builder;
    }

    public static ImmutableMap$Builder builderWithExpectedSize(int n10) {
        CollectPreconditions.checkNonnegative(n10, "expectedSize");
        ImmutableMap$Builder immutableMap$Builder = new ImmutableMap$Builder(n10);
        return immutableMap$Builder;
    }

    public static void checkNoConflict(boolean bl2, String string2, Map.Entry entry, Map.Entry entry2) {
        if (bl2) {
            return;
        }
        throw ImmutableMap.conflictException(string2, entry, entry2);
    }

    public static IllegalArgumentException conflictException(String string2, Object object, Object object2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Multiple entries with same ");
        stringBuilder.append(string2);
        stringBuilder.append(": ");
        stringBuilder.append(object);
        stringBuilder.append(" and ");
        stringBuilder.append(object2);
        string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        return illegalArgumentException;
    }

    public static ImmutableMap copyOf(Iterable iterable) {
        int n10 = iterable instanceof Collection;
        if (n10 != 0) {
            Iterable iterable2 = iterable;
            iterable2 = (Collection)iterable;
            n10 = iterable2.size();
        } else {
            n10 = 4;
        }
        ImmutableMap$Builder immutableMap$Builder = new ImmutableMap$Builder(n10);
        immutableMap$Builder.putAll(iterable);
        return immutableMap$Builder.build();
    }

    public static ImmutableMap copyOf(Map map) {
        boolean bl2 = map instanceof ImmutableMap;
        if (bl2 && !(bl2 = map instanceof SortedMap)) {
            Map map2 = map;
            map2 = (ImmutableMap)map;
            boolean bl3 = ((ImmutableMap)map2).isPartialView();
            if (!bl3) {
                return map2;
            }
        }
        return ImmutableMap.copyOf(map.entrySet());
    }

    public static Map.Entry entryOf(Object object, Object object2) {
        CollectPreconditions.checkEntryNotNull(object, object2);
        AbstractMap.SimpleImmutableEntry<Object, Object> simpleImmutableEntry = new AbstractMap.SimpleImmutableEntry<Object, Object>(object, object2);
        return simpleImmutableEntry;
    }

    public static ImmutableMap of() {
        return RegularImmutableMap.EMPTY;
    }

    public static ImmutableMap of(Object object, Object object2) {
        CollectPreconditions.checkEntryNotNull(object, object2);
        Object[] objectArray = new Object[2];
        objectArray[0] = object;
        int n10 = 1;
        objectArray[n10] = object2;
        return RegularImmutableMap.create(n10, objectArray);
    }

    public static ImmutableMap of(Object object, Object object2, Object object3, Object object4) {
        CollectPreconditions.checkEntryNotNull(object, object2);
        CollectPreconditions.checkEntryNotNull(object3, object4);
        Object[] objectArray = new Object[4];
        objectArray[0] = object;
        objectArray[1] = object2;
        int n10 = 2;
        objectArray[n10] = object3;
        objectArray[3] = object4;
        return RegularImmutableMap.create(n10, objectArray);
    }

    public static ImmutableMap of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6) {
        CollectPreconditions.checkEntryNotNull(object, object2);
        CollectPreconditions.checkEntryNotNull(object3, object4);
        CollectPreconditions.checkEntryNotNull(object5, object6);
        Object[] objectArray = new Object[6];
        objectArray[0] = object;
        objectArray[1] = object2;
        objectArray[2] = object3;
        int n10 = 3;
        objectArray[n10] = object4;
        objectArray[4] = object5;
        objectArray[5] = object6;
        return RegularImmutableMap.create(n10, objectArray);
    }

    public static ImmutableMap of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8) {
        CollectPreconditions.checkEntryNotNull(object, object2);
        CollectPreconditions.checkEntryNotNull(object3, object4);
        CollectPreconditions.checkEntryNotNull(object5, object6);
        CollectPreconditions.checkEntryNotNull(object7, object8);
        Object[] objectArray = new Object[8];
        objectArray[0] = object;
        objectArray[1] = object2;
        objectArray[2] = object3;
        objectArray[3] = object4;
        int n10 = 4;
        objectArray[n10] = object5;
        objectArray[5] = object6;
        objectArray[6] = object7;
        objectArray[7] = object8;
        return RegularImmutableMap.create(n10, objectArray);
    }

    public static ImmutableMap of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10) {
        CollectPreconditions.checkEntryNotNull(object, object2);
        CollectPreconditions.checkEntryNotNull(object3, object4);
        CollectPreconditions.checkEntryNotNull(object5, object6);
        CollectPreconditions.checkEntryNotNull(object7, object8);
        CollectPreconditions.checkEntryNotNull(object9, object10);
        Object[] objectArray = new Object[10];
        objectArray[0] = object;
        objectArray[1] = object2;
        objectArray[2] = object3;
        objectArray[3] = object4;
        objectArray[4] = object5;
        int n10 = 5;
        objectArray[n10] = object6;
        objectArray[6] = object7;
        objectArray[7] = object8;
        objectArray[8] = object9;
        objectArray[9] = object10;
        return RegularImmutableMap.create(n10, objectArray);
    }

    public ImmutableSetMultimap asMultimap() {
        boolean bl2 = this.isEmpty();
        if (bl2) {
            return ImmutableSetMultimap.of();
        }
        ImmutableSetMultimap immutableSetMultimap = this.multimapView;
        if (immutableSetMultimap == null) {
            ImmutableMap$MapViewOfValuesAsSingletonSets immutableMap$MapViewOfValuesAsSingletonSets = new ImmutableMap$MapViewOfValuesAsSingletonSets(this, null);
            int n10 = this.size();
            this.multimapView = immutableSetMultimap = new ImmutableSetMultimap(immutableMap$MapViewOfValuesAsSingletonSets, n10, null);
        }
        return immutableSetMultimap;
    }

    public final void clear() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public boolean containsKey(Object object) {
        boolean bl2;
        if ((object = this.get(object)) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean containsValue(Object object) {
        return this.values().contains(object);
    }

    public abstract ImmutableSet createEntrySet();

    public abstract ImmutableSet createKeySet();

    public abstract ImmutableCollection createValues();

    public ImmutableSet entrySet() {
        ImmutableSet immutableSet = this.entrySet;
        if (immutableSet == null) {
            this.entrySet = immutableSet = this.createEntrySet();
        }
        return immutableSet;
    }

    public boolean equals(Object object) {
        return Maps.equalsImpl(this, object);
    }

    public abstract Object get(Object var1);

    public final Object getOrDefault(Object object, Object object2) {
        if ((object = this.get(object)) != null) {
            object2 = object;
        }
        return object2;
    }

    public int hashCode() {
        return Sets.hashCodeImpl(this.entrySet());
    }

    public boolean isEmpty() {
        int n10 = this.size();
        n10 = n10 == 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean isHashCodeFast() {
        return false;
    }

    public abstract boolean isPartialView();

    public UnmodifiableIterator keyIterator() {
        UnmodifiableIterator unmodifiableIterator = this.entrySet().iterator();
        ImmutableMap$1 immutableMap$1 = new ImmutableMap$1(this, unmodifiableIterator);
        return immutableMap$1;
    }

    public ImmutableSet keySet() {
        ImmutableSet immutableSet = this.keySet;
        if (immutableSet == null) {
            this.keySet = immutableSet = this.createKeySet();
        }
        return immutableSet;
    }

    public final Object put(Object object, Object object2) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public final void putAll(Map object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public final Object remove(Object object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public String toString() {
        return Maps.toStringImpl(this);
    }

    public ImmutableCollection values() {
        ImmutableCollection immutableCollection = this.values;
        if (immutableCollection == null) {
            this.values = immutableCollection = this.createValues();
        }
        return immutableCollection;
    }

    public Object writeReplace() {
        ImmutableMap$SerializedForm immutableMap$SerializedForm = new ImmutableMap$SerializedForm(this);
        return immutableMap$SerializedForm;
    }
}

