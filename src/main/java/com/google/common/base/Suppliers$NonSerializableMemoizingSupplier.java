/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;

public class Suppliers$NonSerializableMemoizingSupplier
implements Supplier {
    public volatile Supplier delegate;
    public volatile boolean initialized;
    public Object value;

    public Suppliers$NonSerializableMemoizingSupplier(Supplier supplier) {
        this.delegate = supplier = (Supplier)Preconditions.checkNotNull(supplier);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object get() {
        boolean bl2 = this.initialized;
        if (bl2) return this.value;
        synchronized (this) {
            boolean bl3;
            bl2 = this.initialized;
            if (bl2) return this.value;
            Object object = this.delegate;
            this.value = object = object.get();
            this.initialized = bl3 = true;
            bl3 = false;
            this.delegate = null;
            return object;
        }
    }

    public String toString() {
        Object object = this.delegate;
        StringBuilder stringBuilder = new StringBuilder();
        Object object2 = "Suppliers.memoize(";
        stringBuilder.append((String)object2);
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("<supplier that returned ");
            object2 = this.value;
            ((StringBuilder)object).append(object2);
            object2 = ">";
            ((StringBuilder)object).append((String)object2);
            object = ((StringBuilder)object).toString();
        }
        stringBuilder.append(object);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

