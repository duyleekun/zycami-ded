/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzav;
import com.google.android.gms.internal.mlkit_vision_face.zzax;
import com.google.android.gms.internal.mlkit_vision_face.zzbd;
import com.google.android.gms.internal.mlkit_vision_face.zzm;
import com.google.android.gms.internal.mlkit_vision_face.zzo;
import com.google.android.gms.internal.mlkit_vision_face.zzr;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class zzp
extends zzbd {
    public final transient Map zza;
    public final /* synthetic */ zzm zzb;

    public zzp(zzm zzm2, Map map) {
        this.zzb = zzm2;
        this.zza = map;
    }

    public final void clear() {
        Object object = this.zza;
        Map map = zzm.zza(this.zzb);
        if (object == map) {
            this.zzb.zzb();
            return;
        }
        object = new zzr(this);
        zzav.zza((Iterator)object);
    }

    public final boolean containsKey(Object object) {
        return zzax.zzb(this.zza, object);
    }

    public final boolean equals(Object object) {
        Map map;
        boolean bl2;
        return this == object || (bl2 = (map = this.zza).equals(object));
        {
        }
    }

    public final /* synthetic */ Object get(Object object) {
        Collection collection = (Collection)zzax.zza(this.zza, object);
        if (collection == null) {
            return null;
        }
        return this.zzb.zza(object, collection);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final Set keySet() {
        return this.zzb.zzf();
    }

    public final /* synthetic */ Object remove(Object object) {
        Object object2 = this.zza;
        if ((object = (Collection)object2.remove(object)) == null) {
            return null;
        }
        object2 = this.zzb.zza();
        object2.addAll(object);
        zzm zzm2 = this.zzb;
        int n10 = object.size();
        zzm.zzb(zzm2, n10);
        object.clear();
        return object2;
    }

    public final int size() {
        return this.zza.size();
    }

    public final String toString() {
        return this.zza.toString();
    }

    public final Set zza() {
        zzo zzo2 = new zzo(this);
        return zzo2;
    }
}

