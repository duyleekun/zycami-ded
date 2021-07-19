/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Multiset$Entry;
import java.util.Comparator;

public final class Multisets$DecreasingCount
implements Comparator {
    public static final Multisets$DecreasingCount INSTANCE;

    static {
        Multisets$DecreasingCount multisets$DecreasingCount;
        INSTANCE = multisets$DecreasingCount = new Multisets$DecreasingCount();
    }

    private Multisets$DecreasingCount() {
    }

    public int compare(Multiset$Entry multiset$Entry, Multiset$Entry multiset$Entry2) {
        int n10 = multiset$Entry2.getCount();
        int n11 = multiset$Entry.getCount();
        return n10 - n11;
    }
}

