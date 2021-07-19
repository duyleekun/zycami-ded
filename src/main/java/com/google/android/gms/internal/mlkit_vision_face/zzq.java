/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzav;
import com.google.android.gms.internal.mlkit_vision_face.zzbb;
import com.google.android.gms.internal.mlkit_vision_face.zzm;
import com.google.android.gms.internal.mlkit_vision_face.zzt;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class zzq
extends zzbb {
    public final /* synthetic */ zzm zza;

    public zzq(zzm zzm2, Map map) {
        this.zza = zzm2;
        super(map);
    }

    public final void clear() {
        zzav.zza(((zzbb)this).iterator());
    }

    public final boolean containsAll(Collection collection) {
        return this.zzb.keySet().containsAll(collection);
    }

    public final boolean equals(Object object) {
        Set set;
        boolean bl2;
        return this == object || (bl2 = (set = this.zzb.keySet()).equals(object));
        {
        }
    }

    public final int hashCode() {
        return this.zzb.keySet().hashCode();
    }

    public final Iterator iterator() {
        Iterator iterator2 = this.zzb.entrySet().iterator();
        zzt zzt2 = new zzt(this, iterator2);
        return zzt2;
    }

    public final boolean remove(Object object) {
        int n10;
        if ((object = (Collection)this.zzb.remove(object)) != null) {
            n10 = object.size();
            object.clear();
            object = this.zza;
            zzm.zzb((zzm)object, n10);
        } else {
            n10 = 0;
        }
        return n10 > 0;
    }
}

