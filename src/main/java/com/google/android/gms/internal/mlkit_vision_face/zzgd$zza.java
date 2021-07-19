/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzet;
import com.google.android.gms.internal.mlkit_vision_face.zzeu;
import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zzf;
import com.google.android.gms.internal.mlkit_vision_face.zzhl;
import com.google.android.gms.internal.mlkit_vision_face.zzhn;
import com.google.android.gms.internal.mlkit_vision_face.zzia;
import com.google.android.gms.internal.mlkit_vision_face.zziu;

public class zzgd$zza
extends zzet {
    public zzgd zza;
    public boolean zzb;
    private final zzgd zzc;

    public zzgd$zza(zzgd zzgd2) {
        this.zzc = zzgd2;
        int n10 = zzgd$zzf.zzd;
        this.zza = zzgd2 = (zzgd)zzgd2.zza(n10, null, null);
        this.zzb = false;
    }

    private static void zza(zzgd zzgd2, zzgd zzgd3) {
        zzia.zza().zza(zzgd2).zzb(zzgd2, zzgd3);
    }

    public final boolean a_() {
        return zzgd.zza(this.zza, false);
    }

    public /* synthetic */ Object clone() {
        zzhn zzhn2 = this.zzc;
        int n10 = zzgd$zzf.zze;
        zzhn2 = (zzgd$zza)((zzgd)zzhn2).zza(n10, null, null);
        zzgd zzgd2 = (zzgd)this.zzg();
        ((zzgd$zza)zzhn2).zza(zzgd2);
        return zzhn2;
    }

    public final /* synthetic */ zzet zza(zzeu zzeu2) {
        zzeu2 = (zzgd)zzeu2;
        return this.zza((zzgd)zzeu2);
    }

    public final zzgd$zza zza(zzgd zzgd2) {
        boolean bl2 = this.zzb;
        if (bl2) {
            this.zzc();
            bl2 = false;
            this.zzb = false;
        }
        zzgd$zza.zza(this.zza, zzgd2);
        return this;
    }

    public final /* synthetic */ zzet zzb() {
        return (zzgd$zza)((zzet)this).clone();
    }

    public void zzc() {
        zzgd zzgd2 = this.zza;
        int n10 = zzgd$zzf.zzd;
        zzgd2 = (zzgd)zzgd2.zza(n10, null, null);
        zzgd zzgd3 = this.zza;
        zzgd$zza.zza(zzgd2, zzgd3);
        this.zza = zzgd2;
    }

    public zzgd zze() {
        boolean bl2 = this.zzb;
        if (bl2) {
            return this.zza;
        }
        zzgd zzgd2 = this.zza;
        zzia.zza().zza(zzgd2).zzc(zzgd2);
        this.zzb = true;
        return this.zza;
    }

    public final zzgd zzf() {
        zzgd zzgd2 = (zzgd)this.zzg();
        boolean bl2 = zzgd2.a_();
        if (bl2) {
            return zzgd2;
        }
        zziu zziu2 = new zziu(zzgd2);
        throw zziu2;
    }

    public /* synthetic */ zzhl zzg() {
        return this.zze();
    }

    public /* synthetic */ zzhl zzh() {
        return this.zzf();
    }

    public final /* synthetic */ zzhl zzi() {
        return this.zzc;
    }
}

