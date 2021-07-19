/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Supplier;
import com.google.common.collect.Maps;
import java.io.Serializable;
import java.util.Map;

public class HashBasedTable$Factory
implements Supplier,
Serializable {
    private static final long serialVersionUID;
    public final int expectedSize;

    public HashBasedTable$Factory(int n10) {
        this.expectedSize = n10;
    }

    public Map get() {
        return Maps.newLinkedHashMapWithExpectedSize(this.expectedSize);
    }
}

