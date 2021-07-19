/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.BiMap;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.ImmutableBiMap$Builder;
import com.google.common.collect.ImmutableBiMap$SerializedForm;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableBiMap;
import java.util.Collection;
import java.util.Map;

public abstract class ImmutableBiMap
extends ImmutableMap
implements BiMap {
    public static ImmutableBiMap$Builder builder() {
        ImmutableBiMap$Builder immutableBiMap$Builder = new ImmutableBiMap$Builder();
        return immutableBiMap$Builder;
    }

    public static ImmutableBiMap$Builder builderWithExpectedSize(int n10) {
        CollectPreconditions.checkNonnegative(n10, "expectedSize");
        ImmutableBiMap$Builder immutableBiMap$Builder = new ImmutableBiMap$Builder(n10);
        return immutableBiMap$Builder;
    }

    public static ImmutableBiMap copyOf(Iterable iterable) {
        int n10 = iterable instanceof Collection;
        if (n10 != 0) {
            Iterable iterable2 = iterable;
            iterable2 = (Collection)iterable;
            n10 = iterable2.size();
        } else {
            n10 = 4;
        }
        ImmutableBiMap$Builder immutableBiMap$Builder = new ImmutableBiMap$Builder(n10);
        return immutableBiMap$Builder.putAll(iterable).build();
    }

    public static ImmutableBiMap copyOf(Map map) {
        boolean bl2 = map instanceof ImmutableBiMap;
        if (bl2) {
            Map map2 = map;
            map2 = (ImmutableBiMap)map;
            boolean bl3 = ((ImmutableMap)map2).isPartialView();
            if (!bl3) {
                return map2;
            }
        }
        return ImmutableBiMap.copyOf(map.entrySet());
    }

    public static ImmutableBiMap of() {
        return RegularImmutableBiMap.EMPTY;
    }

    public static ImmutableBiMap of(Object object, Object object2) {
        CollectPreconditions.checkEntryNotNull(object, object2);
        Object[] objectArray = new Object[2];
        objectArray[0] = object;
        int n10 = 1;
        objectArray[n10] = object2;
        RegularImmutableBiMap regularImmutableBiMap = new RegularImmutableBiMap(objectArray, n10);
        return regularImmutableBiMap;
    }

    public static ImmutableBiMap of(Object object, Object object2, Object object3, Object object4) {
        CollectPreconditions.checkEntryNotNull(object, object2);
        CollectPreconditions.checkEntryNotNull(object3, object4);
        Object[] objectArray = new Object[4];
        objectArray[0] = object;
        objectArray[1] = object2;
        int n10 = 2;
        objectArray[n10] = object3;
        objectArray[3] = object4;
        RegularImmutableBiMap regularImmutableBiMap = new RegularImmutableBiMap(objectArray, n10);
        return regularImmutableBiMap;
    }

    public static ImmutableBiMap of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6) {
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
        RegularImmutableBiMap regularImmutableBiMap = new RegularImmutableBiMap(objectArray, n10);
        return regularImmutableBiMap;
    }

    public static ImmutableBiMap of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8) {
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
        RegularImmutableBiMap regularImmutableBiMap = new RegularImmutableBiMap(objectArray, n10);
        return regularImmutableBiMap;
    }

    public static ImmutableBiMap of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10) {
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
        RegularImmutableBiMap regularImmutableBiMap = new RegularImmutableBiMap(objectArray, n10);
        return regularImmutableBiMap;
    }

    public final ImmutableSet createValues() {
        AssertionError assertionError = new AssertionError((Object)"should never be called");
        throw assertionError;
    }

    public Object forcePut(Object object, Object object2) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public abstract ImmutableBiMap inverse();

    public ImmutableSet values() {
        return ((ImmutableMap)((Object)this.inverse())).keySet();
    }

    public Object writeReplace() {
        ImmutableBiMap$SerializedForm immutableBiMap$SerializedForm = new ImmutableBiMap$SerializedForm(this);
        return immutableBiMap$SerializedForm;
    }
}

