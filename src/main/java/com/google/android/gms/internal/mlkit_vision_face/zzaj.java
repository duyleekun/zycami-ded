/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzaf;
import com.google.android.gms.internal.mlkit_vision_face.zzam;
import com.google.android.gms.internal.mlkit_vision_face.zzh;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

public final class zzaj
extends AbstractSet {
    private final /* synthetic */ zzaf zza;

    public zzaj(zzaf zzaf2) {
        this.zza = zzaf2;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final boolean contains(Object object) {
        boolean bl2;
        int n10;
        Object object2;
        Map map = this.zza.zzb();
        if (map != null) {
            return map.entrySet().contains(object);
        }
        int n11 = object instanceof Map.Entry;
        return n11 != 0 && (n11 = zzaf.zzb((zzaf)(map = this.zza), object2 = (object = (Map.Entry)object).getKey())) != (n10 = -1) && (bl2 = zzh.zza(map = (object2 = this.zza.zzc)[n11], object = object.getValue()));
    }

    public final Iterator iterator() {
        return this.zza.zzf();
    }

    public final boolean remove(Object object) {
        Map map = this.zza.zzb();
        if (map != null) {
            return map.entrySet().remove(object);
        }
        boolean n10 = object instanceof Map.Entry;
        if (n10) {
            int n11;
            object = (Map.Entry)object;
            map = this.zza;
            boolean bl2 = ((zzaf)map).zza();
            if (bl2) {
                return false;
            }
            map = this.zza;
            int n12 = zzaf.zzb((zzaf)map);
            Object k10 = object.getKey();
            Object v10 = object.getValue();
            Object object2 = zzaf.zzc(this.zza);
            object = this.zza;
            int[] nArray = ((zzaf)object).zza;
            Object[] objectArray = ((zzaf)object).zzb;
            Object[] objectArray2 = ((zzaf)object).zzc;
            int n13 = zzam.zza(k10, v10, n12, object2, nArray, objectArray, objectArray2);
            if (n13 == (n11 = -1)) {
                return false;
            }
            this.zza.zza(n13, n12);
            zzaf.zzd(this.zza);
            this.zza.zzc();
            return true;
        }
        return false;
    }

    public final int size() {
        return this.zza.size();
    }
}

