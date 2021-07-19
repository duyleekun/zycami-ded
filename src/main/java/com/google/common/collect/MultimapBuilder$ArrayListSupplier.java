/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Supplier;
import com.google.common.collect.CollectPreconditions;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public final class MultimapBuilder$ArrayListSupplier
implements Supplier,
Serializable {
    private final int expectedValuesPerKey;

    public MultimapBuilder$ArrayListSupplier(int n10) {
        this.expectedValuesPerKey = n10 = CollectPreconditions.checkNonnegative(n10, "expectedValuesPerKey");
    }

    public List get() {
        int n10 = this.expectedValuesPerKey;
        ArrayList arrayList = new ArrayList(n10);
        return arrayList;
    }
}

