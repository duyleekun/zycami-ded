/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzj;
import com.google.android.gms.internal.mlkit_vision_face.zzm;
import com.google.android.gms.internal.mlkit_vision_face.zzq;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class zzt
implements Iterator {
    private Map.Entry zza;
    private final /* synthetic */ Iterator zzb;
    private final /* synthetic */ zzq zzc;

    public zzt(zzq zzq2, Iterator iterator2) {
        this.zzc = zzq2;
        this.zzb = iterator2;
    }

    public final boolean hasNext() {
        return this.zzb.hasNext();
    }

    public final Object next() {
        Map.Entry entry;
        this.zza = entry = (Map.Entry)this.zzb.next();
        return entry.getKey();
    }

    public final void remove() {
        boolean bl2;
        Object object = this.zza;
        if (object != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        zzj.zza(bl2, (Object)"no calls to next() since the last call to remove()");
        object = (Collection)this.zza.getValue();
        this.zzb.remove();
        zzm zzm2 = this.zzc.zza;
        int n10 = object.size();
        zzm.zzb(zzm2, n10);
        object.clear();
        this.zza = null;
    }
}

