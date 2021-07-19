/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.SortedLists$KeyPresentBehavior;
import java.util.Comparator;
import java.util.List;

public final class SortedLists$KeyPresentBehavior$2
extends SortedLists$KeyPresentBehavior {
    public int resultIndex(Comparator comparator, Object object, List list, int n10) {
        int n11 = list.size() + -1;
        while (n10 < n11) {
            int n12 = n10 + n11 + 1 >>> 1;
            Object e10 = list.get(n12);
            int n13 = comparator.compare(e10, object);
            if (n13 > 0) {
                n11 = n12 += -1;
                continue;
            }
            n10 = n12;
        }
        return n10;
    }
}

