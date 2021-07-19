/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzeb;
import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zze;
import com.google.android.gms.internal.mlkit_vision_common.zzfr;
import com.google.android.gms.internal.mlkit_vision_common.zzft;

public class zzej$zzb
extends zzej$zza
implements zzft {
    public zzej$zzb(zzej$zze zzej$zze) {
        super(zzej$zze);
    }

    public void zzc() {
        super.zzc();
        Object object = this.zza;
        zzej zzej2 = object;
        zzej2 = (zzej$zze)object;
        ((zzej$zze)zzej2).zzc = object = (zzeb)((zzej$zze)object).zzc.clone();
    }

    public /* synthetic */ zzej zze() {
        return (zzej$zze)((zzej$zza)this).zzg();
    }

    public /* synthetic */ zzfr zzg() {
        boolean bl2 = this.zzb;
        if (bl2) {
            return (zzej$zze)this.zza;
        }
        ((zzej$zze)this.zza).zzc.zzb();
        return (zzej$zze)super.zze();
    }
}

