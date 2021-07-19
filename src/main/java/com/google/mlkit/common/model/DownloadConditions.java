/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.model;

import com.google.android.gms.common.internal.Objects;
import com.google.mlkit.common.model.zza;

public class DownloadConditions {
    private final boolean zza;
    private final boolean zzb;

    private DownloadConditions(boolean bl2, boolean bl3) {
        this.zza = bl2;
        this.zzb = bl3;
    }

    public /* synthetic */ DownloadConditions(boolean bl2, boolean bl3, zza zza2) {
        this(bl2, bl3);
    }

    public boolean equals(Object object) {
        boolean bl2;
        boolean bl3 = true;
        if (object == this) {
            return bl3;
        }
        boolean bl4 = object instanceof DownloadConditions;
        if (!bl4) {
            return false;
        }
        object = (DownloadConditions)object;
        bl4 = this.zza;
        boolean bl5 = ((DownloadConditions)object).zza;
        if (bl4 == bl5 && (bl4 = this.zzb) == (bl2 = ((DownloadConditions)object).zzb)) {
            return bl3;
        }
        return false;
    }

    public int hashCode() {
        Object[] objectArray = new Object[2];
        Boolean bl2 = this.zza;
        objectArray[0] = bl2;
        bl2 = this.zzb;
        objectArray[1] = bl2;
        return Objects.hashCode(objectArray);
    }

    public boolean isChargingRequired() {
        return this.zza;
    }

    public boolean isWifiRequired() {
        return this.zzb;
    }
}

