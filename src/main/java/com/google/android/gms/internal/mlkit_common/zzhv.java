/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzfn;
import com.google.android.gms.internal.mlkit_common.zzhs;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzhv
extends zzhs {
    public zzhv(int n10) {
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
                object = (zzfn)entry.getKey();
                bl2 = object.zzd();
                if (!bl2) continue;
                object = Collections.unmodifiableList((List)entry.getValue());
                entry.setValue(object);
            }
            iterator2 = this.zzd().iterator();
            while ((n11 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                entry = (Map.Entry)iterator2.next();
                object = (zzfn)entry.getKey();
                bl2 = object.zzd();
                if (!bl2) continue;
                object = Collections.unmodifiableList((List)entry.getValue());
                entry.setValue(object);
            }
        }
        super.zza();
    }
}

