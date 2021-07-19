/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzby;
import com.google.android.gms.internal.clearcut.zzcg;
import com.google.android.gms.internal.clearcut.zzcg$zza;
import com.google.android.gms.internal.clearcut.zzcg$zzd;
import com.google.android.gms.internal.clearcut.zzdo;
import com.google.android.gms.internal.clearcut.zzdq;

public class zzcg$zzc
extends zzcg$zza
implements zzdq {
    public zzcg$zzc(zzcg$zzd zzcg$zzd) {
        super(zzcg$zzd);
    }

    public final void zzbf() {
        boolean bl2 = this.zzju;
        if (!bl2) {
            return;
        }
        super.zzbf();
        Object object = this.zzjt;
        zzcg zzcg2 = object;
        zzcg2 = (zzcg$zzd)object;
        ((zzcg$zzd)zzcg2).zzjv = object = (zzby)((zzcg$zzd)object).zzjv.clone();
    }

    public final /* synthetic */ zzcg zzbg() {
        return (zzcg$zzd)((zzcg$zza)this).zzbi();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final /* synthetic */ zzdo zzbi() {
        zzcg zzcg2;
        boolean bl2 = this.zzju;
        if (bl2) {
            zzcg2 = this.zzjt;
            return (zzcg$zzd)zzcg2;
        }
        ((zzcg$zzd)this.zzjt).zzjv.zzv();
        zzcg2 = super.zzbg();
        return (zzcg$zzd)zzcg2;
    }
}

