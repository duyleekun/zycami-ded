/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzhv;
import com.google.android.gms.internal.vision.zzid;
import com.google.android.gms.internal.vision.zzid$zza;
import com.google.android.gms.internal.vision.zzig;
import com.google.android.gms.internal.vision.zzjm;
import com.google.android.gms.internal.vision.zzjn;
import com.google.android.gms.internal.vision.zzjs;
import com.google.android.gms.internal.vision.zzlk;
import com.google.android.gms.internal.vision.zzlr;

public final class zzid$zzd
implements zzhv {
    public final int number;
    public final zzig zzyc = null;
    public final zzlk zzyd;
    public final boolean zzye;
    public final boolean zzyf;

    public zzid$zzd(zzig zzig2, int n10, zzlk zzlk2, boolean bl2, boolean bl3) {
        this.number = 202056002;
        this.zzyd = zzlk2;
        this.zzye = true;
        this.zzyf = false;
    }

    public final /* synthetic */ int compareTo(Object object) {
        object = (zzid$zzd)object;
        int n10 = this.number;
        int n11 = ((zzid$zzd)object).number;
        return n10 - n11;
    }

    public final zzjm zza(zzjm zzjm2, zzjn zzjn2) {
        zzjm2 = (zzid$zza)zzjm2;
        zzjn2 = (zzid)zzjn2;
        return ((zzid$zza)zzjm2).zza((zzid)zzjn2);
    }

    public final zzjs zza(zzjs object, zzjs zzjs2) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public final int zzak() {
        return this.number;
    }

    public final zzlk zzgm() {
        return this.zzyd;
    }

    public final zzlr zzgn() {
        return this.zzyd.zzjk();
    }

    public final boolean zzgo() {
        return this.zzye;
    }

    public final boolean zzgp() {
        return false;
    }
}

