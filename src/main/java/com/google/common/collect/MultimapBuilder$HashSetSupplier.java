/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Supplier;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Platform;
import java.io.Serializable;
import java.util.Set;

public final class MultimapBuilder$HashSetSupplier
implements Supplier,
Serializable {
    private final int expectedValuesPerKey;

    public MultimapBuilder$HashSetSupplier(int n10) {
        this.expectedValuesPerKey = n10 = CollectPreconditions.checkNonnegative(n10, "expectedValuesPerKey");
    }

    public Set get() {
        return Platform.newHashSetWithExpectedSize(this.expectedValuesPerKey);
    }
}

