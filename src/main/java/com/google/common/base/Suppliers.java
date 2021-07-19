/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers$ExpiringMemoizingSupplier;
import com.google.common.base.Suppliers$MemoizingSupplier;
import com.google.common.base.Suppliers$NonSerializableMemoizingSupplier;
import com.google.common.base.Suppliers$SupplierComposition;
import com.google.common.base.Suppliers$SupplierFunctionImpl;
import com.google.common.base.Suppliers$SupplierOfInstance;
import com.google.common.base.Suppliers$ThreadSafeSupplier;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

public final class Suppliers {
    private Suppliers() {
    }

    public static Supplier compose(Function function, Supplier supplier) {
        Suppliers$SupplierComposition suppliers$SupplierComposition = new Suppliers$SupplierComposition(function, supplier);
        return suppliers$SupplierComposition;
    }

    public static Supplier memoize(Supplier supplier) {
        boolean bl2 = supplier instanceof Suppliers$NonSerializableMemoizingSupplier;
        if (!bl2 && !(bl2 = supplier instanceof Suppliers$MemoizingSupplier)) {
            bl2 = supplier instanceof Serializable;
            Supplier supplier2 = bl2 ? new Suppliers$MemoizingSupplier(supplier) : new Suppliers$NonSerializableMemoizingSupplier(supplier);
            return supplier2;
        }
        return supplier;
    }

    public static Supplier memoizeWithExpiration(Supplier supplier, long l10, TimeUnit timeUnit) {
        Suppliers$ExpiringMemoizingSupplier suppliers$ExpiringMemoizingSupplier = new Suppliers$ExpiringMemoizingSupplier(supplier, l10, timeUnit);
        return suppliers$ExpiringMemoizingSupplier;
    }

    public static Supplier ofInstance(Object object) {
        Suppliers$SupplierOfInstance suppliers$SupplierOfInstance = new Suppliers$SupplierOfInstance(object);
        return suppliers$SupplierOfInstance;
    }

    public static Function supplierFunction() {
        return Suppliers$SupplierFunctionImpl.INSTANCE;
    }

    public static Supplier synchronizedSupplier(Supplier supplier) {
        Suppliers$ThreadSafeSupplier suppliers$ThreadSafeSupplier = new Suppliers$ThreadSafeSupplier(supplier);
        return suppliers$ThreadSafeSupplier;
    }
}

