/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzar;
import com.google.android.gms.internal.mlkit_vision_face.zzj;
import com.google.android.gms.internal.mlkit_vision_face.zzm;
import com.google.android.gms.internal.mlkit_vision_face.zzp;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class zzr
implements Iterator {
    private final Iterator zza;
    private Collection zzb;
    private final /* synthetic */ zzp zzc;

    public zzr(zzp object) {
        this.zzc = object;
        this.zza = object = ((zzp)object).zza.entrySet().iterator();
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* synthetic */ Object next() {
        Object object = (Map.Entry)this.zza.next();
        Object object2 = (Collection)object.getValue();
        this.zzb = object2;
        object2 = this.zzc;
        Object k10 = object.getKey();
        object2 = ((zzp)object2).zzb;
        object = (Collection)object.getValue();
        object = ((zzm)object2).zza(k10, (Collection)object);
        object2 = new zzar(k10, object);
        return object2;
    }

    public final void remove() {
        boolean bl2;
        Object object = this.zzb;
        if (object != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        zzj.zza(bl2, (Object)"no calls to next() since the last call to remove()");
        this.zza.remove();
        object = this.zzc.zzb;
        int n10 = this.zzb.size();
        zzm.zzb((zzm)object, n10);
        this.zzb.clear();
        this.zzb = null;
    }
}

