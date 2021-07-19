/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzbn;
import com.google.android.gms.internal.clearcut.zzby;
import com.google.android.gms.internal.clearcut.zzdh;
import com.google.android.gms.internal.clearcut.zzfl;

public final class zzdg {
    public static int zza(zzdh zzdh2, Object object, Object object2) {
        int n10 = zzby.zza(zzdh2.zzmb, 1, object);
        int n11 = zzby.zza(zzdh2.zzmd, 2, object2);
        return n10 + n11;
    }

    public static void zza(zzbn zzbn2, zzdh object, Object object2, Object object3) {
        zzfl zzfl2 = object.zzmb;
        zzby.zza(zzbn2, zzfl2, 1, object2);
        object = object.zzmd;
        zzby.zza(zzbn2, (zzfl)((Object)object), 2, object3);
    }
}

