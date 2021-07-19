/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import java.util.Iterator;

public interface PeekingIterator
extends Iterator {
    public Object next();

    public Object peek();

    public void remove();
}

