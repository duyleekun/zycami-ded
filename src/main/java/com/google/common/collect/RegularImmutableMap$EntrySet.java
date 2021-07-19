/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableMap$EntrySet$1;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Map;

public class RegularImmutableMap$EntrySet
extends ImmutableSet {
    private final transient Object[] alternatingKeysAndValues;
    private final transient int keyOffset;
    private final transient ImmutableMap map;
    private final transient int size;

    public RegularImmutableMap$EntrySet(ImmutableMap immutableMap, Object[] objectArray, int n10, int n11) {
        this.map = immutableMap;
        this.alternatingKeysAndValues = objectArray;
        this.keyOffset = n10;
        this.size = n11;
    }

    public static /* synthetic */ int access$000(RegularImmutableMap$EntrySet regularImmutableMap$EntrySet) {
        return regularImmutableMap$EntrySet.size;
    }

    public static /* synthetic */ Object[] access$100(RegularImmutableMap$EntrySet regularImmutableMap$EntrySet) {
        return regularImmutableMap$EntrySet.alternatingKeysAndValues;
    }

    public static /* synthetic */ int access$200(RegularImmutableMap$EntrySet regularImmutableMap$EntrySet) {
        return regularImmutableMap$EntrySet.keyOffset;
    }

    public boolean contains(Object object) {
        boolean bl2 = object instanceof Map.Entry;
        boolean bl3 = false;
        if (bl2) {
            ImmutableMap immutableMap;
            boolean bl4;
            object = (Map.Entry)object;
            Object object2 = object.getKey();
            if ((object = object.getValue()) != null && (bl4 = object.equals(object2 = (immutableMap = this.map).get(object2)))) {
                bl3 = true;
            }
        }
        return bl3;
    }

    public int copyIntoArray(Object[] objectArray, int n10) {
        return this.asList().copyIntoArray(objectArray, n10);
    }

    public ImmutableList createAsList() {
        RegularImmutableMap$EntrySet$1 regularImmutableMap$EntrySet$1 = new RegularImmutableMap$EntrySet$1(this);
        return regularImmutableMap$EntrySet$1;
    }

    public boolean isPartialView() {
        return true;
    }

    public UnmodifiableIterator iterator() {
        return this.asList().iterator();
    }

    public int size() {
        return this.size;
    }
}

