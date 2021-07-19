/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.Camera$ShutterCallback
 */
package com.google.android.gms.vision;

import android.hardware.Camera;
import com.google.android.gms.vision.CameraSource$ShutterCallback;
import com.google.android.gms.vision.zza;

public final class CameraSource$zzd
implements Camera.ShutterCallback {
    private CameraSource$ShutterCallback zzag;

    private CameraSource$zzd() {
    }

    public /* synthetic */ CameraSource$zzd(zza zza2) {
        this();
    }

    public static /* synthetic */ CameraSource$ShutterCallback zza(CameraSource$zzd cameraSource$zzd, CameraSource$ShutterCallback cameraSource$ShutterCallback) {
        cameraSource$zzd.zzag = cameraSource$ShutterCallback;
        return cameraSource$ShutterCallback;
    }

    public final void onShutter() {
        CameraSource$ShutterCallback cameraSource$ShutterCallback = this.zzag;
        if (cameraSource$ShutterCallback != null) {
            cameraSource$ShutterCallback.onShutter();
        }
    }
}

