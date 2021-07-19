/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.Camera
 *  android.hardware.Camera$PictureCallback
 */
package com.google.android.gms.vision;

import android.hardware.Camera;
import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.CameraSource$PictureCallback;
import com.google.android.gms.vision.zza;

public final class CameraSource$zzc
implements Camera.PictureCallback {
    private final /* synthetic */ CameraSource zzae;
    private CameraSource$PictureCallback zzaf;

    private CameraSource$zzc(CameraSource cameraSource) {
        this.zzae = cameraSource;
    }

    public /* synthetic */ CameraSource$zzc(CameraSource cameraSource, zza zza2) {
        this(cameraSource);
    }

    public static /* synthetic */ CameraSource$PictureCallback zza(CameraSource$zzc cameraSource$zzc, CameraSource$PictureCallback cameraSource$PictureCallback) {
        cameraSource$zzc.zzaf = cameraSource$PictureCallback;
        return cameraSource$PictureCallback;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void onPictureTaken(byte[] object, Camera object2) {
        object2 = this.zzaf;
        if (object2 != null) {
            object2.onPictureTaken((byte[])object);
        }
        object = CameraSource.zza(this.zzae);
        synchronized (object) {
            object2 = this.zzae;
            object2 = CameraSource.zzb((CameraSource)object2);
            if (object2 != null) {
                object2 = this.zzae;
                object2 = CameraSource.zzb((CameraSource)object2);
                object2.startPreview();
            }
            return;
        }
    }
}

