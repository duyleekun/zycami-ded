/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

public abstract class zzlh {
    public abstract int zzb(int var1, byte[] var2, int var3, int var4);

    public abstract int zzb(CharSequence var1, byte[] var2, int var3, int var4);

    public final boolean zzf(byte[] byArray, int n10, int n11) {
        int n12 = this.zzb(0, byArray, n10, n11);
        return n12 == 0;
    }

    public abstract String zzh(byte[] var1, int var2, int var3);
}

