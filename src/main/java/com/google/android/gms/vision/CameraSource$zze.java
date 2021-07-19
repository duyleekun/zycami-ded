/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.Camera$Size
 */
package com.google.android.gms.vision;

import android.hardware.Camera;
import com.google.android.gms.common.images.Size;

public final class CameraSource$zze {
    private Size zzaj;
    private Size zzak;

    public CameraSource$zze(Camera.Size object, Camera.Size size) {
        Size size2;
        int n10 = object.width;
        int n11 = object.height;
        this.zzaj = size2 = new Size(n10, n11);
        if (size != null) {
            int n12 = size.width;
            int n13 = size.height;
            super(n12, n13);
            this.zzak = object;
        }
    }

    public final Size zzd() {
        return this.zzaj;
    }

    public final Size zze() {
        return this.zzak;
    }
}

