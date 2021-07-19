/*
 * Decompiled with CFR 0.151.
 */
package androidx.arch.core.internal;

import androidx.arch.core.internal.SafeIterableMap$Entry;
import androidx.arch.core.internal.SafeIterableMap$ListIterator;

public class SafeIterableMap$DescendingIterator
extends SafeIterableMap$ListIterator {
    public SafeIterableMap$DescendingIterator(SafeIterableMap$Entry safeIterableMap$Entry, SafeIterableMap$Entry safeIterableMap$Entry2) {
        super(safeIterableMap$Entry, safeIterableMap$Entry2);
    }

    public SafeIterableMap$Entry backward(SafeIterableMap$Entry safeIterableMap$Entry) {
        return safeIterableMap$Entry.mNext;
    }

    public SafeIterableMap$Entry forward(SafeIterableMap$Entry safeIterableMap$Entry) {
        return safeIterableMap$Entry.mPrevious;
    }
}

