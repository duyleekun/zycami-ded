/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzdh;
import com.google.android.gms.internal.clearcut.zzdi;
import com.google.android.gms.internal.clearcut.zzdj;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class zzdk
implements zzdj {
    public final int zzb(int n10, Object object, Object object2) {
        n10 = (int)(((HashMap)(object = (zzdi)object)).isEmpty() ? 1 : 0);
        if (n10 != 0) {
            return 0;
        }
        Iterator iterator2 = ((zzdi)object).entrySet().iterator();
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

    public final Object zzb(Object object, Object object2) {
        object = (zzdi)object;
        boolean bl2 = ((HashMap)(object2 = (zzdi)object2)).isEmpty();
        if (!bl2) {
            bl2 = ((zzdi)object).isMutable();
            if (!bl2) {
                object = ((zzdi)object).zzca();
            }
            ((zzdi)object).zza((zzdi)object2);
        }
        return object;
    }

    public final Map zzg(Object object) {
        return (zzdi)object;
    }

    public final Map zzh(Object object) {
        return (zzdi)object;
    }

    public final boolean zzi(Object object) {
        boolean bl2 = ((zzdi)(object = (zzdi)object)).isMutable();
        return !bl2;
    }

    public final Object zzj(Object object) {
        ((zzdi)object).zzv();
        return object;
    }

    public final Object zzk(Object object) {
        return zzdi.zzbz().zzca();
    }

    public final zzdh zzl(Object object) {
        object = new NoSuchMethodError();
        throw object;
    }
}

