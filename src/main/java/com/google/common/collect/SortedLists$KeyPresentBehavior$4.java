/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.SortedLists$KeyPresentBehavior;
import java.util.Comparator;
import java.util.List;

public final class SortedLists$KeyPresentBehavior$4
extends SortedLists$KeyPresentBehavior {
    public int resultIndex(Comparator comparator, Object object, List list, int n10) {
        return SortedLists$KeyPresentBehavior.LAST_PRESENT.resultIndex(comparator, object, list, n10) + 1;
    }
}

