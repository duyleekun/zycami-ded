/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzca;
import com.google.android.gms.internal.clearcut.zzei;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzej
extends zzei {
    public zzej(int n10) {
        super(n10, null);
    }

    public final void zzv() {
        int n10 = this.isImmutable();
        if (n10 == 0) {
            boolean bl2;
            Object object;
            Map.Entry entry;
            int n11;
            Iterator iterator2 = null;
            for (n10 = 0; n10 < (n11 = this.zzdr()); ++n10) {
                entry = this.zzak(n10);
                object = (zzca)entry.getKey();
                bl2 = object.zzaw();
                if (!bl2) continue;
                object = Collections.unmodifiableList((List)entry.getValue());
                entry.setValue(object);
            }
            iterator2 = this.zzds().iterator();
            while ((n11 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                entry = (Map.Entry)iterator2.next();
                object = (zzca)entry.getKey();
                bl2 = object.zzaw();
                if (!bl2) continue;
                object = Collections.unmodifiableList((List)entry.getValue());
                entry.setValue(object);
            }
        }
        super.zzv();
    }
}

