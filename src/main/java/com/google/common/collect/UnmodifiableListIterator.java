/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.UnmodifiableIterator;
import java.util.ListIterator;

public abstract class UnmodifiableListIterator
extends UnmodifiableIterator
implements ListIterator {
    public final void add(Object object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public final void set(Object object) {
        object = new UnsupportedOperationException();
        throw object;
    }
}

