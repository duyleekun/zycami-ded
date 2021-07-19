/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.model;

import com.google.mlkit.common.model.DownloadConditions;

public class DownloadConditions$Builder {
    private boolean zza = false;
    private boolean zzb = false;

    public DownloadConditions build() {
        boolean bl2 = this.zza;
        boolean bl3 = this.zzb;
        DownloadConditions downloadConditions = new DownloadConditions(bl2, bl3, null);
        return downloadConditions;
    }

    public DownloadConditions$Builder requireCharging() {
        this.zza = true;
        return this;
    }

    public DownloadConditions$Builder requireWifi() {
        this.zzb = true;
        return this;
    }
}

