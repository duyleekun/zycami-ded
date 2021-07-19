/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableMap;
import com.google.common.collect.RegularImmutableMap$EntrySet;
import com.google.common.collect.RegularImmutableMap$KeySet;
import com.google.common.collect.RegularImmutableMap$KeysOrValuesAsList;

public final class RegularImmutableBiMap
extends ImmutableBiMap {
    public static final RegularImmutableBiMap EMPTY;
    public final transient Object[] alternatingKeysAndValues;
    private final transient RegularImmutableBiMap inverse;
    private final transient Object keyHashTable;
    private final transient int keyOffset;
    private final transient int size;

    static {
        RegularImmutableBiMap regularImmutableBiMap;
        EMPTY = regularImmutableBiMap = new RegularImmutableBiMap();
    }

    private RegularImmutableBiMap() {
        this.keyHashTable = null;
        Object[] objectArray = new Object[]{};
        this.alternatingKeysAndValues = objectArray;
        this.keyOffset = 0;
        this.size = 0;
        this.inverse = this;
    }

    private RegularImmutableBiMap(Object object, Object[] objectArray, int n10, RegularImmutableBiMap regularImmutableBiMap) {
        this.keyHashTable = object;
        this.alternatingKeysAndValues = objectArray;
        this.keyOffset = 1;
        this.size = n10;
        this.inverse = regularImmutableBiMap;
    }

    public RegularImmutableBiMap(Object[] objectArray, int n10) {
        RegularImmutableBiMap regularImmutableBiMap;
        this.alternatingKeysAndValues = objectArray;
        this.size = n10;
        Object object = null;
        this.keyOffset = 0;
        int n11 = 2;
        if (n10 >= n11) {
            n11 = ImmutableSet.chooseTableSize(n10);
        } else {
            n11 = 0;
            regularImmutableBiMap = null;
        }
        this.keyHashTable = object = RegularImmutableMap.createHashTable(objectArray, n10, n11, 0);
        object = RegularImmutableMap.createHashTable(objectArray, n10, n11, 1);
        this.inverse = regularImmutableBiMap = new RegularImmutableBiMap(object, objectArray, n10, this);
    }

    public ImmutableSet createEntrySet() {
        Object[] objectArray = this.alternatingKeysAndValues;
        int n10 = this.keyOffset;
        int n11 = this.size;
        RegularImmutableMap$EntrySet regularImmutableMap$EntrySet = new RegularImmutableMap$EntrySet(this, objectArray, n10, n11);
        return regularImmutableMap$EntrySet;
    }

    public ImmutableSet createKeySet() {
        Object object = this.alternatingKeysAndValues;
        int n10 = this.keyOffset;
        int n11 = this.size;
        RegularImmutableMap$KeysOrValuesAsList regularImmutableMap$KeysOrValuesAsList = new RegularImmutableMap$KeysOrValuesAsList((Object[])object, n10, n11);
        object = new RegularImmutableMap$KeySet(this, regularImmutableMap$KeysOrValuesAsList);
        return object;
    }

    public Object get(Object object) {
        Object object2 = this.keyHashTable;
        Object[] objectArray = this.alternatingKeysAndValues;
        int n10 = this.size;
        int n11 = this.keyOffset;
        return RegularImmutableMap.get(object2, objectArray, n10, n11, object);
    }

    public ImmutableBiMap inverse() {
        return this.inverse;
    }

    public boolean isPartialView() {
        return false;
    }

    public int size() {
        return this.size;
    }
}

