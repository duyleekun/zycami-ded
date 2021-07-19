/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMapValues$1;
import com.google.common.collect.ImmutableMapValues$2;
import com.google.common.collect.ImmutableMapValues$SerializedForm;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;

public final class ImmutableMapValues
extends ImmutableCollection {
    private final ImmutableMap map;

    public ImmutableMapValues(ImmutableMap immutableMap) {
        this.map = immutableMap;
    }

    public static /* synthetic */ ImmutableMap access$000(ImmutableMapValues immutableMapValues) {
        return immutableMapValues.map;
    }

    public ImmutableList asList() {
        ImmutableList immutableList = this.map.entrySet().asList();
        ImmutableMapValues$2 immutableMapValues$2 = new ImmutableMapValues$2(this, immutableList);
        return immutableMapValues$2;
    }

    public boolean contains(Object object) {
        UnmodifiableIterator unmodifiableIterator;
        boolean bl2;
        if (object != null && (bl2 = Iterators.contains(unmodifiableIterator = this.iterator(), object))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean isPartialView() {
        return true;
    }

    public UnmodifiableIterator iterator() {
        ImmutableMapValues$1 immutableMapValues$1 = new ImmutableMapValues$1(this);
        return immutableMapValues$1;
    }

    public int size() {
        return this.map.size();
    }

    public Object writeReplace() {
        ImmutableMap immutableMap = this.map;
        ImmutableMapValues$SerializedForm immutableMapValues$SerializedForm = new ImmutableMapValues$SerializedForm(immutableMap);
        return immutableMapValues$SerializedForm;
    }
}

