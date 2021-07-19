/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzbu;
import com.google.android.gms.internal.vision.zzbv;
import com.google.android.gms.internal.vision.zzde;
import com.google.android.gms.internal.vision.zzeh;

public final class zzbs {
    private final boolean zzhf;

    public zzbs(zzbv zzbv2) {
        boolean bl2;
        zzde.checkNotNull(zzbv2, "BuildInfo must be non-null");
        this.zzhf = bl2 = zzbv2.zzai() ^ true;
    }

    public final boolean zzg(String string2) {
        String string3 = "flagName must not be null";
        zzde.checkNotNull(string2, string3);
        boolean bl2 = this.zzhf;
        if (!bl2) {
            return true;
        }
        return ((zzeh)zzbu.zzhh.get()).containsValue(string2);
    }
}

