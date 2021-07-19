/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import java.util.Iterator;

public abstract class UnmodifiableIterator
implements Iterator {
    public final void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }
}

