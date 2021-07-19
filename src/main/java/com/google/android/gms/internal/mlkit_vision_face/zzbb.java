/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzaw;
import com.google.android.gms.internal.mlkit_vision_face.zzbg;
import com.google.android.gms.internal.mlkit_vision_face.zzj;
import java.util.Iterator;
import java.util.Map;

public class zzbb
extends zzbg {
    public final Map zzb;

    public zzbb(Map map) {
        this.zzb = map = (Map)zzj.zza(map);
    }

    public void clear() {
        this.zzb.clear();
    }

    public boolean contains(Object object) {
        return this.zzb.containsKey(object);
    }

    public boolean isEmpty() {
        return this.zzb.isEmpty();
    }

    public Iterator iterator() {
        Iterator iterator2 = this.zzb.entrySet().iterator();
        zzaw zzaw2 = new zzaw(iterator2);
        return zzaw2;
    }

    public boolean remove(Object object) {
        boolean bl2 = this.contains(object);
        if (bl2) {
            this.zzb.remove(object);
            return true;
        }
        return false;
    }

    public int size() {
        return this.zzb.size();
    }
}

