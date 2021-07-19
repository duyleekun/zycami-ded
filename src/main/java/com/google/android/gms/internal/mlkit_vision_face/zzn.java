/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzau;
import com.google.android.gms.internal.mlkit_vision_face.zzm;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public abstract class zzn
extends zzm
implements zzau {
    public zzn(Map map) {
        super(map);
    }

    public /* synthetic */ Collection zza() {
        return this.zze();
    }

    public /* synthetic */ Collection zza(Object object) {
        return this.zzb(object);
    }

    public final Collection zza(Object object, Collection collection) {
        collection = (List)collection;
        return this.zza(object, (List)collection, null);
    }

    public List zzb(Object object) {
        return (List)super.zza(object);
    }

    public abstract List zze();
}

