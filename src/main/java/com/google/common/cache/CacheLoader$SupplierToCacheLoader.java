/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.cache.CacheLoader;
import java.io.Serializable;

public final class CacheLoader$SupplierToCacheLoader
extends CacheLoader
implements Serializable {
    private static final long serialVersionUID;
    private final Supplier computingSupplier;

    public CacheLoader$SupplierToCacheLoader(Supplier supplier) {
        this.computingSupplier = supplier = (Supplier)Preconditions.checkNotNull(supplier);
    }

    public Object load(Object object) {
        Preconditions.checkNotNull(object);
        return this.computingSupplier.get();
    }
}

