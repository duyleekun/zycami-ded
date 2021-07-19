/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzde;
import com.google.android.gms.internal.vision.zzee;

public final class zzep
extends zzee {
    public static final zzee zznk;
    private final transient int size;
    private final transient Object[] zznl;

    static {
        Object[] objectArray = new Object[]{};
        zzep zzep2 = new zzep(objectArray, 0);
        zznk = zzep2;
    }

    public zzep(Object[] objectArray, int n10) {
        this.zznl = objectArray;
        this.size = n10;
    }

    public final Object get(int n10) {
        int n11 = this.size;
        zzde.zzd(n10, n11);
        return this.zznl[n10];
    }

    public final int size() {
        return this.size;
    }

    public final int zza(Object[] objectArray, int n10) {
        Object[] objectArray2 = this.zznl;
        int n11 = this.size;
        System.arraycopy(objectArray2, 0, objectArray, n10, n11);
        int n12 = this.size;
        return n10 + n12;
    }

    public final Object[] zzcq() {
        return this.zznl;
    }

    public final int zzcr() {
        return 0;
    }

    public final int zzcs() {
        return this.size;
    }

    public final boolean zzcu() {
        return false;
    }
}

