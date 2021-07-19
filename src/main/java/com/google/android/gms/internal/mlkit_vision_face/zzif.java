/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzfx;
import com.google.android.gms.internal.mlkit_vision_face.zzig;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzif
extends zzig {
    public zzif(int n10) {
        super(n10, null);
    }

    public final void zza() {
        int n10 = this.zzb();
        if (n10 == 0) {
            boolean bl2;
            Object object;
            Map.Entry entry;
            int n11;
            Iterator iterator2 = null;
            for (n10 = 0; n10 < (n11 = this.zzc()); ++n10) {
                entry = this.zzb(n10);
                object = (zzfx)entry.getKey();
                bl2 = object.zzd();
                if (!bl2) continue;
                object = Collections.unmodifiableList((List)entry.getValue());
                entry.setValue(object);
            }
            iterator2 = this.zzd().iterator();
            while ((n11 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                entry = (Map.Entry)iterator2.next();
                object = (zzfx)entry.getKey();
                bl2 = object.zzd();
                if (!bl2) continue;
                object = Collections.unmodifiableList((List)entry.getValue());
                entry.setValue(object);
            }
        }
        super.zza();
    }
}

