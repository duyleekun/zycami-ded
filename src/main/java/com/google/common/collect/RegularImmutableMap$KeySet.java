/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;

public final class RegularImmutableMap$KeySet
extends ImmutableSet {
    private final transient ImmutableList list;
    private final transient ImmutableMap map;

    public RegularImmutableMap$KeySet(ImmutableMap immutableMap, ImmutableList immutableList) {
        this.map = immutableMap;
        this.list = immutableList;
    }

    public ImmutableList asList() {
        return this.list;
    }

    public boolean contains(Object object) {
        boolean bl2;
        ImmutableMap immutableMap = this.map;
        if ((object = immutableMap.get(object)) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public int copyIntoArray(Object[] objectArray, int n10) {
        return this.asList().copyIntoArray(objectArray, n10);
    }

    public boolean isPartialView() {
        return true;
    }

    public UnmodifiableIterator iterator() {
        return this.asList().iterator();
    }

    public int size() {
        return this.map.size();
    }
}

