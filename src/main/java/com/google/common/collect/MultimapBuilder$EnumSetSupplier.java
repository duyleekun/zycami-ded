/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.EnumSet;
import java.util.Set;

public final class MultimapBuilder$EnumSetSupplier
implements Supplier,
Serializable {
    private final Class clazz;

    public MultimapBuilder$EnumSetSupplier(Class clazz) {
        this.clazz = clazz = (Class)Preconditions.checkNotNull(clazz);
    }

    public Set get() {
        return EnumSet.noneOf(this.clazz);
    }
}

