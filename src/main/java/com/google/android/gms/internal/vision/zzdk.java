/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzde;
import com.google.android.gms.internal.vision.zzdf;

public final class zzdk
implements zzdf {
    private Object value;
    private volatile zzdf zzmb;
    private volatile boolean zzmc;

    public zzdk(zzdf zzdf2) {
        this.zzmb = zzdf2 = (zzdf)zzde.checkNotNull(zzdf2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object get() {
        boolean bl2 = this.zzmc;
        if (bl2) return this.value;
        synchronized (this) {
            boolean bl3;
            bl2 = this.zzmc;
            if (bl2) return this.value;
            Object object = this.zzmb;
            this.value = object = object.get();
            this.zzmc = bl3 = true;
            bl3 = false;
            this.zzmb = null;
            return object;
        }
    }

    public final String toString() {
        StringBuilder stringBuilder;
        int n10;
        Object object = this.zzmb;
        if (object == null) {
            object = String.valueOf(this.value);
            n10 = String.valueOf(object).length() + 25;
            stringBuilder = new StringBuilder(n10);
            String string2 = "<supplier that returned ";
            stringBuilder.append(string2);
            stringBuilder.append((String)object);
            stringBuilder.append(">");
            object = stringBuilder.toString();
        }
        object = String.valueOf(object);
        n10 = String.valueOf(object).length() + 19;
        stringBuilder = new StringBuilder(n10);
        stringBuilder.append("Suppliers.memoize(");
        stringBuilder.append((String)object);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

