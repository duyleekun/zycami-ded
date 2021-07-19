/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.SmallSortedMap$EmptySet$1;
import com.google.protobuf.SmallSortedMap$EmptySet$2;
import java.util.Iterator;

public class SmallSortedMap$EmptySet {
    private static final Iterable ITERABLE;
    private static final Iterator ITERATOR;

    static {
        Object object = new SmallSortedMap$EmptySet$1();
        ITERATOR = object;
        ITERABLE = object = new SmallSortedMap$EmptySet$2();
    }

    private SmallSortedMap$EmptySet() {
    }

    public static /* synthetic */ Iterator access$1000() {
        return ITERATOR;
    }

    public static Iterable iterable() {
        return ITERABLE;
    }
}

