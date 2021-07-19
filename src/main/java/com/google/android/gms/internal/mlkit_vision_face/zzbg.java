/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzbf;
import com.google.android.gms.internal.mlkit_vision_face.zzbh;
import com.google.android.gms.internal.mlkit_vision_face.zzj;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public abstract class zzbg
extends AbstractSet {
    public boolean removeAll(Collection object) {
        int n10;
        zzj.zza(object);
        int n11 = object instanceof zzbf;
        if (n11 != 0) {
            object = ((zzbf)object).zza();
        }
        if ((n11 = object instanceof Set) != 0 && (n11 = object.size()) > (n10 = this.size())) {
            boolean bl2;
            Iterator iterator2 = this.iterator();
            zzj.zza(object);
            n10 = 0;
            while (bl2 = iterator2.hasNext()) {
                Object e10 = iterator2.next();
                bl2 = ((Collection)object).contains(e10);
                if (!bl2) continue;
                iterator2.remove();
                n10 = 1;
            }
            return n10;
        }
        object = object.iterator();
        return zzbh.zza(this, (Iterator)object);
    }

    public boolean retainAll(Collection collection) {
        collection = (Collection)zzj.zza(collection);
        return super.retainAll(collection);
    }
}

