/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.Camera
 *  android.hardware.Camera$PreviewCallback
 */
package com.google.android.gms.vision;

import android.hardware.Camera;
import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.zza;

public final class CameraSource$zzb
implements Camera.PreviewCallback {
    private final /* synthetic */ CameraSource zzae;

    private CameraSource$zzb(CameraSource cameraSource) {
        this.zzae = cameraSource;
    }

    public /* synthetic */ CameraSource$zzb(CameraSource cameraSource, zza zza2) {
        this(cameraSource);
    }

    public final void onPreviewFrame(byte[] byArray, Camera camera) {
        CameraSource.zzc(this.zzae).zza(byArray, camera);
    }
}

