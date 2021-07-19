/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap$IteratorBasedImmutableMap$1EntrySetImpl;
import com.google.common.collect.ImmutableMapKeySet;
import com.google.common.collect.ImmutableMapValues;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;

public abstract class ImmutableMap$IteratorBasedImmutableMap
extends ImmutableMap {
    public ImmutableSet createEntrySet() {
        ImmutableMap$IteratorBasedImmutableMap$1EntrySetImpl immutableMap$IteratorBasedImmutableMap$1EntrySetImpl = new ImmutableMap$IteratorBasedImmutableMap$1EntrySetImpl(this);
        return immutableMap$IteratorBasedImmutableMap$1EntrySetImpl;
    }

    public ImmutableSet createKeySet() {
        ImmutableMapKeySet immutableMapKeySet = new ImmutableMapKeySet(this);
        return immutableMapKeySet;
    }

    public ImmutableCollection createValues() {
        ImmutableMapValues immutableMapValues = new ImmutableMapValues(this);
        return immutableMapValues;
    }

    public abstract UnmodifiableIterator entryIterator();
}

