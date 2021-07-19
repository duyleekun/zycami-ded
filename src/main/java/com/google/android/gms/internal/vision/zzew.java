/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzde;
import com.google.android.gms.internal.vision.zzee;

public final class zzew
extends zzee {
    private final transient int offset;
    private final transient int size;
    private final transient Object[] zznd;

    public zzew(Object[] objectArray, int n10, int n11) {
        this.zznd = objectArray;
        this.offset = n10;
        this.size = n11;
    }

    public final Object get(int n10) {
        int n11 = this.size;
        zzde.zzd(n10, n11);
        Object[] objectArray = this.zznd;
        n10 *= 2;
        int n12 = this.offset;
        return objectArray[n10 += n12];
    }

    public final int size() {
        return this.size;
    }

    public final boolean zzcu() {
        return true;
    }
}

