/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Platform;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

public class Suppliers$ExpiringMemoizingSupplier
implements Supplier,
Serializable {
    private static final long serialVersionUID;
    public final Supplier delegate;
    public final long durationNanos;
    public volatile transient long expirationNanos;
    public volatile transient Object value;

    public Suppliers$ExpiringMemoizingSupplier(Supplier supplier, long l10, TimeUnit timeUnit) {
        long l11;
        this.delegate = supplier = (Supplier)Preconditions.checkNotNull(supplier);
        this.durationNanos = l11 = timeUnit.toNanos(l10);
        l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 > 0) {
            l12 = 1;
        } else {
            l12 = 0;
            supplier = null;
        }
        Preconditions.checkArgument((boolean)l12, "duration (%s %s) must be > 0", l10, (Object)timeUnit);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object get() {
        long l10;
        long l11;
        long l12 = this.expirationNanos;
        long l13 = Platform.systemNanoTime();
        long l14 = 0L;
        long l15 = l12 - l14;
        Object object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object == false || (object = (l11 = (l10 = l13 - l12) - l14) == 0L ? 0 : (l11 < 0L ? -1 : 1)) >= 0) {
            synchronized (this) {
                l10 = this.expirationNanos;
                long l16 = l12 == l10 ? 0 : (l12 < l10 ? -1 : 1);
                if (l16 == false) {
                    Object object2 = this.delegate;
                    this.value = object2 = object2.get();
                    l10 = this.durationNanos;
                    long l17 = (l13 += l10) - l14;
                    Object object3 = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
                    if (object3 == false) {
                        l13 = 1L;
                    }
                    this.expirationNanos = l13;
                    return object2;
                }
            }
        }
        return this.value;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Suppliers.memoizeWithExpiration(");
        Supplier supplier = this.delegate;
        stringBuilder.append(supplier);
        stringBuilder.append(", ");
        long l10 = this.durationNanos;
        stringBuilder.append(l10);
        stringBuilder.append(", NANOS)");
        return stringBuilder.toString();
    }
}

