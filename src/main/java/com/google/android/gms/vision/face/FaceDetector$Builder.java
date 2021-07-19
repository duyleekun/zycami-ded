/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.gms.vision.face;

import android.content.Context;
import com.google.android.gms.vision.face.FaceDetector;
import com.google.android.gms.vision.face.internal.client.zzb;
import com.google.android.gms.vision.face.internal.client.zzf;

public class FaceDetector$Builder {
    private int landmarkType = 0;
    private int mode = 0;
    private float proportionalMinFaceSize = -1.0f;
    private boolean trackingEnabled = true;
    private boolean zzcv = false;
    private int zzcw = 0;
    private final Context zzg;

    public FaceDetector$Builder(Context context) {
        this.zzg = context;
    }

    public FaceDetector build() {
        float f10;
        int n10;
        Object object = new zzf();
        ((zzf)object).mode = n10 = this.mode;
        ((zzf)object).landmarkType = n10 = this.landmarkType;
        ((zzf)object).zzcw = n10 = this.zzcw;
        n10 = (int)(this.zzcv ? 1 : 0);
        ((zzf)object).zzcv = n10;
        n10 = (int)(this.trackingEnabled ? 1 : 0);
        ((zzf)object).trackingEnabled = n10;
        ((zzf)object).proportionalMinFaceSize = f10 = this.proportionalMinFaceSize;
        n10 = (int)(FaceDetector.zzb((zzf)object) ? 1 : 0);
        if (n10 != 0) {
            Context context = this.zzg;
            zzb zzb2 = new zzb(context, (zzf)object);
            object = new FaceDetector(zzb2, null);
            return object;
        }
        object = new IllegalArgumentException("Invalid build options");
        throw object;
    }

    public FaceDetector$Builder setClassificationType(int n10) {
        int n11;
        if (n10 != 0 && n10 != (n11 = 1)) {
            StringBuilder stringBuilder = new StringBuilder(40);
            stringBuilder.append("Invalid classification type: ");
            stringBuilder.append(n10);
            String string2 = stringBuilder.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
            throw illegalArgumentException;
        }
        this.zzcw = n10;
        return this;
    }

    public FaceDetector$Builder setLandmarkType(int n10) {
        int n11;
        if (n10 != 0 && n10 != (n11 = 1) && n10 != (n11 = 2)) {
            StringBuilder stringBuilder = new StringBuilder(34);
            stringBuilder.append("Invalid landmark type: ");
            stringBuilder.append(n10);
            String string2 = stringBuilder.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
            throw illegalArgumentException;
        }
        this.landmarkType = n10;
        return this;
    }

    public FaceDetector$Builder setMinFaceSize(float f10) {
        float f11;
        float f12 = 0.0f;
        IllegalArgumentException illegalArgumentException = null;
        float f13 = f10 - 0.0f;
        Object object = f13 == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1);
        if (object >= 0 && (object = (f11 = f10 - (f12 = 1.0f)) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1)) <= 0) {
            this.proportionalMinFaceSize = f10;
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder(47);
        stringBuilder.append("Invalid proportional face size: ");
        stringBuilder.append(f10);
        String string2 = stringBuilder.toString();
        illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public FaceDetector$Builder setMode(int n10) {
        int n11;
        if (n10 != 0 && n10 != (n11 = 1) && n10 != (n11 = 2)) {
            StringBuilder stringBuilder = new StringBuilder(25);
            stringBuilder.append("Invalid mode: ");
            stringBuilder.append(n10);
            String string2 = stringBuilder.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
            throw illegalArgumentException;
        }
        this.mode = n10;
        return this;
    }

    public FaceDetector$Builder setProminentFaceOnly(boolean bl2) {
        this.zzcv = bl2;
        return this;
    }

    public FaceDetector$Builder setTrackingEnabled(boolean bl2) {
        this.trackingEnabled = bl2;
        return this;
    }
}

