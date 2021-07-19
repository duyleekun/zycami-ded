/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.Serializable;

public class Suppliers$MemoizingSupplier
implements Supplier,
Serializable {
    private static final long serialVersionUID;
    public final Supplier delegate;
    public volatile transient boolean initialized;
    public transient Object value;

    public Suppliers$MemoizingSupplier(Supplier supplier) {
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
            return object;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = "Suppliers.memoize(";
        stringBuilder.append((String)object);
        boolean bl2 = this.initialized;
        if (bl2) {
            object = new StringBuilder();
            ((StringBuilder)object).append("<supplier that returned ");
            Object object2 = this.value;
            ((StringBuilder)object).append(object2);
            object2 = ">";
            ((StringBuilder)object).append((String)object2);
            object = ((StringBuilder)object).toString();
        } else {
            object = this.delegate;
        }
        stringBuilder.append(object);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

