/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ForwardingCollection;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Iterator;

public class Maps$UnmodifiableEntries
extends ForwardingCollection {
    private final Collection entries;

    public Maps$UnmodifiableEntries(Collection collection) {
        this.entries = collection;
    }

    public Collection delegate() {
        return this.entries;
    }

    public Iterator iterator() {
        return Maps.unmodifiableEntryIterator(this.entries.iterator());
    }

    public Object[] toArray() {
        return this.standardToArray();
    }

    public Object[] toArray(Object[] objectArray) {
        return this.standardToArray(objectArray);
    }
}

