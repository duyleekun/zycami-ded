/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import java.util.Comparator;
import java.util.Iterator;

public interface SortedIterable
extends Iterable {
    public Comparator comparator();

    public Iterator iterator();
}

