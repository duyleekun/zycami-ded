/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzb;
import com.google.android.gms.internal.mlkit_vision_face.zzi;
import com.google.android.gms.internal.mlkit_vision_face.zzj;
import java.io.Serializable;

public abstract class zzg
implements Serializable {
    public static zzg zzb() {
        return zzb.zza;
    }

    public static zzg zzb(Object object) {
        object = zzj.zza(object);
        zzi zzi2 = new zzi(object);
        return zzi2;
    }

    public abstract Object zza(Object var1);

    public abstract boolean zza();
}

