/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzhl;
import com.google.android.gms.internal.vision.zzht;
import com.google.android.gms.internal.vision.zzje;
import com.google.android.gms.internal.vision.zzlk;

public final class zzjf {
    public static int zza(zzje zzje2, Object object, Object object2) {
        int n10 = zzht.zza(zzje2.zzaac, 1, object);
        int n11 = zzht.zza(zzje2.zzaae, 2, object2);
        return n10 + n11;
    }

    public static void zza(zzhl zzhl2, zzje object, Object object2, Object object3) {
        zzlk zzlk2 = object.zzaac;
        zzht.zza(zzhl2, zzlk2, 1, object2);
        object = object.zzaae;
        zzht.zza(zzhl2, (zzlk)((Object)object), 2, object3);
    }
}

