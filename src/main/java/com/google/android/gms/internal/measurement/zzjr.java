/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzjl;
import com.google.android.gms.internal.measurement.zzjq;
import com.google.android.gms.internal.measurement.zzjs;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

public final class zzjr
extends AbstractSet {
    public final /* synthetic */ zzjs zza;

    public /* synthetic */ zzjr(zzjs zzjs2, zzjl zzjl2) {
        this.zza = zzjs2;
    }

    public final void clear() {
        this.zza.clear();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final boolean contains(Object object) {
        object = (Map.Entry)object;
        Object object2 = this.zza;
        Object k10 = object.getKey();
        object2 = ((zzjs)object2).get(k10);
        object = object.getValue();
        boolean bl2 = false;
        k10 = null;
        boolean bl3 = true;
        if (object2 == object) return bl3;
        if (object2 == null) return bl2;
        boolean bl4 = object2.equals(object);
        if (!bl4) return false;
        return bl3;
    }

    public final Iterator iterator() {
        zzjs zzjs2 = this.zza;
        zzjq zzjq2 = new zzjq(zzjs2, null);
        return zzjq2;
    }

    public final boolean remove(Object object) {
        boolean bl2 = this.contains(object = (Map.Entry)object);
        if (bl2) {
            zzjs zzjs2 = this.zza;
            object = object.getKey();
            zzjs2.remove(object);
            return true;
        }
        return false;
    }

    public final int size() {
        return this.zza.size();
    }
}

