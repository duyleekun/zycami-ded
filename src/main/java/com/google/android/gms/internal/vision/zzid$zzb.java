/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzht;
import com.google.android.gms.internal.vision.zzid;
import com.google.android.gms.internal.vision.zzid$zza;
import com.google.android.gms.internal.vision.zzid$zze;
import com.google.android.gms.internal.vision.zzjn;
import com.google.android.gms.internal.vision.zzjp;

public class zzid$zzb
extends zzid$zza
implements zzjp {
    public zzid$zzb(zzid$zze zzid$zze) {
        super(zzid$zze);
    }

    public void zzgs() {
        super.zzgs();
        Object object = this.zzxx;
        zzid zzid2 = object;
        zzid2 = (zzid$zze)object;
        ((zzid$zze)zzid2).zzyg = object = (zzht)((zzid$zze)object).zzyg.clone();
    }

    public /* synthetic */ zzid zzgt() {
        return (zzid$zze)((zzid$zza)this).zzgv();
    }

    public /* synthetic */ zzjn zzgv() {
        boolean bl2 = this.zzxy;
        if (bl2) {
            return (zzid$zze)this.zzxx;
        }
        ((zzid$zze)this.zzxx).zzyg.zzej();
        return (zzid$zze)super.zzgt();
    }
}

