/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzde;
import com.google.android.gms.internal.vision.zzee;
import java.util.List;

public final class zzeg
extends zzee {
    private final transient int length;
    private final transient int offset;
    private final /* synthetic */ zzee zznb;

    public zzeg(zzee zzee2, int n10, int n11) {
        this.zznb = zzee2;
        this.offset = n10;
        this.length = n11;
    }

    public final Object get(int n10) {
        int n11 = this.length;
        zzde.zzd(n10, n11);
        zzee zzee2 = this.zznb;
        int n12 = this.offset;
        return zzee2.get(n10 += n12);
    }

    public final int size() {
        return this.length;
    }

    public final /* synthetic */ List subList(int n10, int n11) {
        return ((zzee)this).zzh(n10, n11);
    }

    public final Object[] zzcq() {
        return this.zznb.zzcq();
    }

    public final int zzcr() {
        int n10 = this.zznb.zzcr();
        int n11 = this.offset;
        return n10 + n11;
    }

    public final int zzcs() {
        int n10 = this.zznb.zzcr();
        int n11 = this.offset;
        n10 += n11;
        n11 = this.length;
        return n10 + n11;
    }

    public final boolean zzcu() {
        return true;
    }

    public final zzee zzh(int n10, int n11) {
        int n12 = this.length;
        zzde.zza(n10, n11, n12);
        zzee zzee2 = this.zznb;
        int n13 = this.offset;
        return (zzee)zzee2.subList(n10 += n13, n11 += n13);
    }
}

