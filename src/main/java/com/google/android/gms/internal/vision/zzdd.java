/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzcy;

public final class zzdd
extends zzcy {
    private final Object zzma;

    public zzdd(Object object) {
        this.zzma = object;
    }

    public final boolean equals(Object object) {
        boolean bl2 = object instanceof zzdd;
        if (bl2) {
            object = (zzdd)object;
            Object object2 = this.zzma;
            object = ((zzdd)object).zzma;
            return object2.equals(object);
        }
        return false;
    }

    public final Object get() {
        return this.zzma;
    }

    public final int hashCode() {
        return this.zzma.hashCode() + 1502476572;
    }

    public final boolean isPresent() {
        return true;
    }

    public final String toString() {
        String string2 = String.valueOf(this.zzma);
        int n10 = String.valueOf(string2).length() + 13;
        StringBuilder stringBuilder = new StringBuilder(n10);
        stringBuilder.append("Optional.of(");
        stringBuilder.append(string2);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

