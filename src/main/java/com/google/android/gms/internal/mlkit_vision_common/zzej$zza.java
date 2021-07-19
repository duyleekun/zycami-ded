/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzcz;
import com.google.android.gms.internal.mlkit_vision_common.zzda;
import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzf;
import com.google.android.gms.internal.mlkit_vision_common.zzfr;
import com.google.android.gms.internal.mlkit_vision_common.zzft;
import com.google.android.gms.internal.mlkit_vision_common.zzgg;
import com.google.android.gms.internal.mlkit_vision_common.zzha;

public class zzej$zza
extends zzcz {
    public zzej zza;
    public boolean zzb;
    private final zzej zzc;

    public zzej$zza(zzej zzej2) {
        this.zzc = zzej2;
        int n10 = zzej$zzf.zzd;
        this.zza = zzej2 = (zzej)zzej2.zza(n10, null, null);
        this.zzb = false;
    }

    private static void zza(zzej zzej2, zzej zzej3) {
        zzgg.zza().zza(zzej2).zzb(zzej2, zzej3);
    }

    public final boolean a_() {
        return zzej.zza(this.zza, false);
    }

    public /* synthetic */ Object clone() {
        zzft zzft2 = this.zzc;
        int n10 = zzej$zzf.zze;
        zzft2 = (zzej$zza)((zzej)zzft2).zza(n10, null, null);
        zzej zzej2 = (zzej)this.zzg();
        ((zzej$zza)zzft2).zza(zzej2);
        return zzft2;
    }

    public final /* synthetic */ zzcz zza(zzda zzda2) {
        zzda2 = (zzej)zzda2;
        return this.zza((zzej)zzda2);
    }

    public final zzej$zza zza(zzej zzej2) {
        boolean bl2 = this.zzb;
        if (bl2) {
            this.zzc();
            bl2 = false;
            this.zzb = false;
        }
        zzej$zza.zza(this.zza, zzej2);
        return this;
    }

    public final /* synthetic */ zzcz zzb() {
        return (zzej$zza)((zzcz)this).clone();
    }

    public void zzc() {
        zzej zzej2 = this.zza;
        int n10 = zzej$zzf.zzd;
        zzej2 = (zzej)zzej2.zza(n10, null, null);
        zzej zzej3 = this.zza;
        zzej$zza.zza(zzej2, zzej3);
        this.zza = zzej2;
    }

    public zzej zze() {
        boolean bl2 = this.zzb;
        if (bl2) {
            return this.zza;
        }
        zzej zzej2 = this.zza;
        zzgg.zza().zza(zzej2).zzc(zzej2);
        this.zzb = true;
        return this.zza;
    }

    public final zzej zzf() {
        zzej zzej2 = (zzej)this.zzg();
        boolean bl2 = zzej2.a_();
        if (bl2) {
            return zzej2;
        }
        zzha zzha2 = new zzha(zzej2);
        throw zzha2;
    }

    public /* synthetic */ zzfr zzg() {
        return this.zze();
    }

    public /* synthetic */ zzfr zzh() {
        return this.zzf();
    }

    public final /* synthetic */ zzfr zzi() {
        return this.zzc;
    }
}

