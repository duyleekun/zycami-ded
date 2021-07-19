/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.Serializable;

public class Suppliers$SupplierComposition
implements Supplier,
Serializable {
    private static final long serialVersionUID;
    public final Function function;
    public final Supplier supplier;

    public Suppliers$SupplierComposition(Function object, Supplier supplier) {
        object = (Function)Preconditions.checkNotNull(object);
        this.function = object;
        this.supplier = object = (Supplier)Preconditions.checkNotNull(supplier);
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof Suppliers$SupplierComposition;
        boolean bl3 = false;
        if (bl2) {
            boolean bl4;
            object = (Suppliers$SupplierComposition)object;
            Object object2 = this.function;
            Function function = ((Suppliers$SupplierComposition)object).function;
            bl2 = object2.equals(function);
            if (bl2 && (bl4 = (object2 = this.supplier).equals(object = ((Suppliers$SupplierComposition)object).supplier))) {
                bl3 = true;
            }
        }
        return bl3;
    }

    public Object get() {
        Function function = this.function;
        Object object = this.supplier.get();
        return function.apply(object);
    }

    public int hashCode() {
        Object object = this.function;
        object = this.supplier;
        Object[] objectArray = new Object[]{object, object};
        return Objects.hashCode(objectArray);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Suppliers.compose(");
        Object object = this.function;
        stringBuilder.append(object);
        stringBuilder.append(", ");
        object = this.supplier;
        stringBuilder.append(object);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

