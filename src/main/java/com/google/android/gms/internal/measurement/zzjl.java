/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhi;
import com.google.android.gms.internal.measurement.zzjs;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzjl
extends zzjs {
    public zzjl(int n10) {
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
                entry = this.zzd(n10);
                object = (zzhi)entry.getKey();
                bl2 = object.zzc();
                if (!bl2) continue;
                object = Collections.unmodifiableList((List)entry.getValue());
                entry.setValue(object);
            }
            iterator2 = this.zze().iterator();
            while ((n11 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                entry = (Map.Entry)iterator2.next();
                object = (zzhi)entry.getKey();
                bl2 = object.zzc();
                if (!bl2) continue;
                object = Collections.unmodifiableList((List)entry.getValue());
                entry.setValue(object);
            }
        }
        super.zza();
    }
}

