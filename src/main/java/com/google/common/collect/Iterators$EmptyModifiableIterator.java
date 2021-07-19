/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class Iterators$EmptyModifiableIterator
extends Enum
implements Iterator {
    private static final /* synthetic */ Iterators$EmptyModifiableIterator[] $VALUES;
    public static final /* enum */ Iterators$EmptyModifiableIterator INSTANCE;

    static {
        Iterators$EmptyModifiableIterator iterators$EmptyModifiableIterator;
        INSTANCE = iterators$EmptyModifiableIterator = new Iterators$EmptyModifiableIterator("INSTANCE", 0);
        Iterators$EmptyModifiableIterator[] iterators$EmptyModifiableIteratorArray = new Iterators$EmptyModifiableIterator[]{iterators$EmptyModifiableIterator};
        $VALUES = iterators$EmptyModifiableIteratorArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Iterators$EmptyModifiableIterator() {
        void var2_-1;
        void var1_-1;
    }

    public static Iterators$EmptyModifiableIterator valueOf(String string2) {
        return Enum.valueOf(Iterators$EmptyModifiableIterator.class, string2);
    }

    public static Iterators$EmptyModifiableIterator[] values() {
        return (Iterators$EmptyModifiableIterator[])$VALUES.clone();
    }

    public boolean hasNext() {
        return false;
    }

    public Object next() {
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public void remove() {
        CollectPreconditions.checkRemove(false);
    }
}

