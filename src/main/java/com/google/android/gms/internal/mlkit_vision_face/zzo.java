/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzac;
import com.google.android.gms.internal.mlkit_vision_face.zzay;
import com.google.android.gms.internal.mlkit_vision_face.zzm;
import com.google.android.gms.internal.mlkit_vision_face.zzp;
import com.google.android.gms.internal.mlkit_vision_face.zzr;
import java.util.Iterator;
import java.util.Map;

public final class zzo
extends zzay {
    private final /* synthetic */ zzp zza;

    public zzo(zzp zzp2) {
        this.zza = zzp2;
    }

    public final boolean contains(Object object) {
        return zzac.zza(this.zza.zza.entrySet(), object);
    }

    public final Iterator iterator() {
        zzp zzp2 = this.zza;
        zzr zzr2 = new zzr(zzp2);
        return zzr2;
    }

    public final boolean remove(Object object) {
        boolean bl2 = ((zzay)this).contains(object);
        if (!bl2) {
            return false;
        }
        object = (Map.Entry)object;
        zzm zzm2 = this.zza.zzb;
        object = object.getKey();
        zzm.zza(zzm2, object);
        return true;
    }

    public final Map zza() {
        return this.zza;
    }
}

