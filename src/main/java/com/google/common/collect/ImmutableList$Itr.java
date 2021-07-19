/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIndexedListIterator;
import com.google.common.collect.ImmutableList;

public class ImmutableList$Itr
extends AbstractIndexedListIterator {
    private final ImmutableList list;

    public ImmutableList$Itr(ImmutableList immutableList, int n10) {
        int n11 = immutableList.size();
        super(n11, n10);
        this.list = immutableList;
    }

    public Object get(int n10) {
        return this.list.get(n10);
    }
}

