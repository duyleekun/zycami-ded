/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzad;
import com.google.android.gms.internal.mlkit_vision_face.zzax;
import com.google.android.gms.internal.mlkit_vision_face.zzbg;
import com.google.android.gms.internal.mlkit_vision_face.zzbh;
import com.google.android.gms.internal.mlkit_vision_face.zzh;
import com.google.android.gms.internal.mlkit_vision_face.zzj;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class zzay
extends zzbg {
    public void clear() {
        this.zza().clear();
    }

    public boolean contains(Object object) {
        boolean bl2 = object instanceof Map.Entry;
        if (bl2) {
            object = (Map.Entry)object;
            Object k10 = object.getKey();
            Object object2 = zzax.zza(this.zza(), k10);
            boolean bl3 = zzh.zza(object2, object = object.getValue());
            if (bl3 && (object2 != null || (bl3 = (object = this.zza()).containsKey(k10)))) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return this.zza().isEmpty();
    }

    public boolean remove(Object object) {
        boolean bl2 = this.contains(object);
        if (bl2) {
            object = (Map.Entry)object;
            Set set = this.zza().keySet();
            object = object.getKey();
            return set.remove(object);
        }
        return false;
    }

    public boolean removeAll(Collection object) {
        Object object2;
        try {
            object2 = zzj.zza(object);
        }
        catch (UnsupportedOperationException unsupportedOperationException) {
            object = object.iterator();
            return zzbh.zza(this, (Iterator)object);
        }
        object2 = (Collection)object2;
        return super.removeAll((Collection)object2);
    }

    public boolean retainAll(Collection object) {
        Object object2;
        try {
            object2 = zzj.zza(object);
        }
        catch (UnsupportedOperationException unsupportedOperationException) {
            int n10 = object.size();
            int n11 = 3;
            float f10 = 4.2E-45f;
            if (n10 < n11) {
                String string2 = "expectedSize";
                zzad.zza(n10, string2);
                ++n10;
            } else {
                float f11;
                n11 = 0x40000000;
                f10 = 2.0f;
                if (n10 < n11) {
                    f11 = (float)n10 / 0.75f;
                    n11 = 1065353216;
                    f10 = 1.0f;
                    n10 = (int)(f11 += f10);
                } else {
                    n10 = -1 >>> 1;
                    f11 = 0.0f / 0.0f;
                }
            }
            HashSet<Object> hashSet = new HashSet<Object>(n10);
            object = object.iterator();
            while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                object2 = object.next();
                n11 = (int)(this.contains(object2) ? 1 : 0);
                if (n11 == 0) continue;
                object2 = ((Map.Entry)object2).getKey();
                hashSet.add(object2);
            }
            return this.zza().keySet().retainAll(hashSet);
        }
        object2 = (Collection)object2;
        return super.retainAll((Collection)object2);
    }

    public int size() {
        return this.zza().size();
    }

    public abstract Map zza();
}

