/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Ordering;
import com.google.common.collect.Ordering$ArbitraryOrdering;

public class Ordering$ArbitraryOrderingHolder {
    public static final Ordering ARBITRARY_ORDERING;

    static {
        Ordering$ArbitraryOrdering ordering$ArbitraryOrdering = new Ordering$ArbitraryOrdering();
        ARBITRARY_ORDERING = ordering$ArbitraryOrdering;
    }

    private Ordering$ArbitraryOrderingHolder() {
    }
}

