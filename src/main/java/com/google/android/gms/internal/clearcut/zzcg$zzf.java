/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzbr;
import com.google.android.gms.internal.clearcut.zzcg$zze;
import com.google.android.gms.internal.clearcut.zzdo;
import com.google.android.gms.internal.clearcut.zzfl;

public final class zzcg$zzf
extends zzbr {
    private final Object zzdu;
    private final zzdo zzka;
    private final zzdo zzkb;
    private final zzcg$zze zzkc;

    public zzcg$zzf(zzdo object, Object object2, zzdo zzdo2, zzcg$zze zzcg$zze, Class object3) {
        if (object != null) {
            object3 = zzcg$zze.zzjx;
            zzfl zzfl2 = zzfl.zzqm;
            if (object3 == zzfl2 && zzdo2 == null) {
                object = new IllegalArgumentException("Null messageDefaultInstance");
                throw object;
            }
            this.zzka = object;
            this.zzdu = object2;
            this.zzkb = zzdo2;
            this.zzkc = zzcg$zze;
            return;
        }
        object = new IllegalArgumentException("Null containingTypeDefaultInstance");
        throw object;
    }
}

