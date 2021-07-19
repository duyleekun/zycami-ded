/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzhv;
import com.google.android.gms.internal.vision.zzkg;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzkj
extends zzkg {
    public zzkj(int n10) {
        super(n10, null);
    }

    public final void zzej() {
        int n10 = this.isImmutable();
        if (n10 == 0) {
            boolean bl2;
            Object object;
            Map.Entry entry;
            int n11;
            Iterator iterator2 = null;
            for (n10 = 0; n10 < (n11 = this.zzin()); ++n10) {
                entry = this.zzcc(n10);
                object = (zzhv)entry.getKey();
                bl2 = object.zzgo();
                if (!bl2) continue;
                object = Collections.unmodifiableList((List)entry.getValue());
                entry.setValue(object);
            }
            iterator2 = this.zzio().iterator();
            while ((n11 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                entry = (Map.Entry)iterator2.next();
                object = (zzhv)entry.getKey();
                bl2 = object.zzgo();
                if (!bl2) continue;
                object = Collections.unmodifiableList((List)entry.getValue());
                entry.setValue(object);
            }
        }
        super.zzej();
    }
}

