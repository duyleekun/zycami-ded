/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzde;
import com.google.android.gms.internal.vision.zzee;
import com.google.android.gms.internal.vision.zzer;
import java.util.AbstractMap;

public final class zzeu
extends zzee {
    private final /* synthetic */ zzer zznp;

    public zzeu(zzer zzer2) {
        this.zznp = zzer2;
    }

    public final /* synthetic */ Object get(int n10) {
        int n11 = zzer.zza(this.zznp);
        zzde.zzd(n10, n11);
        Object object = zzer.zzb(this.zznp);
        object = object[n10 *= 2];
        Object object2 = zzer.zzb(this.zznp);
        Object object3 = object2[++n10];
        object2 = new AbstractMap.SimpleImmutableEntry(object, object3);
        return object2;
    }

    public final int size() {
        return zzer.zza(this.zznp);
    }

    public final boolean zzcu() {
        return true;
    }
}

