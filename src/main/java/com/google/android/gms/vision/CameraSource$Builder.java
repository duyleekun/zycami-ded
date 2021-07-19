/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 */
package com.google.android.gms.vision;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.CameraSource$zza;
import com.google.android.gms.vision.Detector;

public class CameraSource$Builder {
    private final Detector zzx;
    private CameraSource zzy;

    public CameraSource$Builder(Context object, Detector detector) {
        CameraSource cameraSource;
        this.zzy = cameraSource = new CameraSource(null);
        if (object != null) {
            if (detector != null) {
                this.zzx = detector;
                CameraSource.zza(cameraSource, object);
                return;
            }
            super("No detector supplied.");
            throw object;
        }
        super("No context supplied.");
        throw object;
    }

    public CameraSource build() {
        CameraSource cameraSource = this.zzy;
        cameraSource.getClass();
        Detector detector = this.zzx;
        CameraSource$zza cameraSource$zza = new CameraSource$zza(cameraSource, detector);
        CameraSource.zza(cameraSource, cameraSource$zza);
        return this.zzy;
    }

    public CameraSource$Builder setAutoFocusEnabled(boolean bl2) {
        CameraSource.zza(this.zzy, bl2);
        return this;
    }

    public CameraSource$Builder setFacing(int n10) {
        int n11;
        if (n10 != 0 && n10 != (n11 = 1)) {
            StringBuilder stringBuilder = new StringBuilder(27);
            stringBuilder.append("Invalid camera: ");
            stringBuilder.append(n10);
            String string2 = stringBuilder.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
            throw illegalArgumentException;
        }
        CameraSource.zzc(this.zzy, n10);
        return this;
    }

    public CameraSource$Builder setFocusMode(String string2) {
        Object object = "continuous-video";
        int n10 = (int)(string2.equals(object) ? 1 : 0);
        if (n10 == 0 && (n10 = string2.equals(object = "continuous-picture")) == 0) {
            n10 = 1;
            object = new Object[n10];
            object[0] = string2;
            string2 = String.format("FocusMode %s is not supported for now.", object);
            object = "CameraSource";
            Log.w((String)object, (String)string2);
            string2 = null;
        }
        CameraSource.zza(this.zzy, string2);
        return this;
    }

    public CameraSource$Builder setRequestedFps(float f10) {
        IllegalArgumentException illegalArgumentException = null;
        float f11 = f10 - 0.0f;
        Object object = f11 == 0.0f ? 0 : (f11 < 0.0f ? -1 : 1);
        if (object > 0) {
            CameraSource.zza(this.zzy, f10);
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder(28);
        stringBuilder.append("Invalid fps: ");
        stringBuilder.append(f10);
        String string2 = stringBuilder.toString();
        illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public CameraSource$Builder setRequestedPreviewSize(int n10, int n11) {
        int n12;
        if (n10 > 0 && n10 <= (n12 = 1000000) && n11 > 0 && n11 <= n12) {
            CameraSource.zza(this.zzy, n10);
            CameraSource.zzb(this.zzy, n11);
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder(45);
        stringBuilder.append("Invalid preview size: ");
        stringBuilder.append(n10);
        stringBuilder.append("x");
        stringBuilder.append(n11);
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }
}

