/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Function;
import com.google.common.base.Functions$1;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.Serializable;

public class Functions$SupplierFunction
implements Function,
Serializable {
    private static final long serialVersionUID;
    private final Supplier supplier;

    private Functions$SupplierFunction(Supplier supplier) {
        this.supplier = supplier = (Supplier)Preconditions.checkNotNull(supplier);
    }

    public /* synthetic */ Functions$SupplierFunction(Supplier supplier, Functions$1 functions$1) {
        this(supplier);
    }

    public Object apply(Object object) {
        return this.supplier.get();
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof Functions$SupplierFunction;
        if (bl2) {
            object = (Functions$SupplierFunction)object;
            Supplier supplier = this.supplier;
            object = ((Functions$SupplierFunction)object).supplier;
            return supplier.equals(object);
        }
        return false;
    }

    public int hashCode() {
        return this.supplier.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Functions.forSupplier(");
        Supplier supplier = this.supplier;
        stringBuilder.append(supplier);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

