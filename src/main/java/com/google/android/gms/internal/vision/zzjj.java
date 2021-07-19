/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzje;
import com.google.android.gms.internal.vision.zzjf;
import com.google.android.gms.internal.vision.zzjg;
import com.google.android.gms.internal.vision.zzjh;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class zzjj
implements zzjg {
    public final int zzb(int n10, Object object, Object object2) {
        object = (zzjh)object;
        object2 = (zzjf)object2;
        n10 = (int)(((HashMap)object).isEmpty() ? 1 : 0);
        object2 = null;
        if (n10 != 0) {
            return 0;
        }
        Iterator iterator2 = ((zzjh)object).entrySet().iterator();
        boolean bl2 = iterator2.hasNext();
        if (!bl2) {
            return 0;
        }
        iterator2 = (Map.Entry)iterator2.next();
        iterator2.getKey();
        iterator2.getValue();
        iterator2 = new NoSuchMethodError();
        throw iterator2;
    }

    public final Object zzc(Object object, Object object2) {
        object = (zzjh)object;
        boolean bl2 = ((HashMap)(object2 = (zzjh)object2)).isEmpty();
        if (!bl2) {
            bl2 = ((zzjh)object).isMutable();
            if (!bl2) {
                object = ((zzjh)object).zzhy();
            }
            ((zzjh)object).zza((zzjh)object2);
        }
        return object;
    }

    public final Map zzn(Object object) {
        return (zzjh)object;
    }

    public final Map zzo(Object object) {
        return (zzjh)object;
    }

    public final boolean zzp(Object object) {
        boolean bl2 = ((zzjh)(object = (zzjh)object)).isMutable();
        return !bl2;
    }

    public final Object zzq(Object object) {
        ((zzjh)object).zzej();
        return object;
    }

    public final Object zzr(Object object) {
        return zzjh.zzhx().zzhy();
    }

    public final zzje zzs(Object object) {
        object = (zzjf)object;
        object = new NoSuchMethodError();
        throw object;
    }
}

