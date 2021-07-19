/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Multiset$Entry;
import java.util.NoSuchElementException;

public final class SortedMultisets {
    private SortedMultisets() {
    }

    public static /* synthetic */ Object access$000(Multiset$Entry multiset$Entry) {
        return SortedMultisets.getElementOrThrow(multiset$Entry);
    }

    public static /* synthetic */ Object access$100(Multiset$Entry multiset$Entry) {
        return SortedMultisets.getElementOrNull(multiset$Entry);
    }

    private static Object getElementOrNull(Multiset$Entry object) {
        object = object == null ? null : object.getElement();
        return object;
    }

    private static Object getElementOrThrow(Multiset$Entry object) {
        if (object != null) {
            return object.getElement();
        }
        object = new NoSuchElementException();
        throw object;
    }
}

