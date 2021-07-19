/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzaf;
import com.google.android.gms.internal.mlkit_vision_face.zzh;
import com.google.android.gms.internal.mlkit_vision_face.zzz;
import java.util.Map;

public final class zzak
extends zzz {
    private final Object zza;
    private int zzb;
    private final /* synthetic */ zzaf zzc;

    public zzak(zzaf object, int n10) {
        this.zzc = object;
        this.zza = object = ((zzaf)object).zzb[n10];
        this.zzb = n10;
    }

    private final void zza() {
        block3: {
            Object object;
            Object object2;
            int n10;
            block2: {
                n10 = this.zzb;
                int n11 = -1;
                if (n10 == n11 || n10 >= (n11 = (object2 = this.zzc).size())) break block2;
                object = this.zza;
                object2 = this.zzc.zzb;
                int n12 = this.zzb;
                n10 = (int)(zzh.zza(object, object2 = object2[n12]) ? 1 : 0);
                if (n10 != 0) break block3;
            }
            object = this.zzc;
            object2 = this.zza;
            this.zzb = n10 = zzaf.zzb((zzaf)object, object2);
        }
    }

    public final Object getKey() {
        return this.zza;
    }

    public final Object getValue() {
        Map map = this.zzc.zzb();
        if (map != null) {
            Object object = this.zza;
            return map.get(object);
        }
        this.zza();
        int n10 = this.zzb;
        int n11 = -1;
        if (n10 == n11) {
            return null;
        }
        return this.zzc.zzc[n10];
    }

    public final Object setValue(Object object) {
        Map map = this.zzc.zzb();
        if (map != null) {
            Object object2 = this.zza;
            return map.put(object2, object);
        }
        this.zza();
        int n10 = this.zzb;
        int n11 = -1;
        if (n10 == n11) {
            map = this.zzc;
            Object object3 = this.zza;
            ((zzaf)map).put(object3, object);
            return null;
        }
        Object[] objectArray = this.zzc.zzc;
        Object object4 = objectArray[n10];
        objectArray[n10] = object;
        return object4;
    }
}

