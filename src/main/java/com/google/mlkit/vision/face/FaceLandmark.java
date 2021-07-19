/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 */
package com.google.mlkit.vision.face;

import android.graphics.PointF;
import com.google.android.gms.internal.mlkit_vision_face.zzd;
import com.google.android.gms.internal.mlkit_vision_face.zzf;

public class FaceLandmark {
    public static final int LEFT_CHEEK = 1;
    public static final int LEFT_EAR = 3;
    public static final int LEFT_EYE = 4;
    public static final int MOUTH_BOTTOM = 0;
    public static final int MOUTH_LEFT = 5;
    public static final int MOUTH_RIGHT = 11;
    public static final int NOSE_BASE = 6;
    public static final int RIGHT_CHEEK = 7;
    public static final int RIGHT_EAR = 9;
    public static final int RIGHT_EYE = 10;
    private final int zza;
    private final PointF zzb;

    public FaceLandmark(int n10, PointF pointF) {
        this.zza = n10;
        this.zzb = pointF;
    }

    public int getLandmarkType() {
        return this.zza;
    }

    public PointF getPosition() {
        return this.zzb;
    }

    public String toString() {
        zzf zzf2 = zzd.zza("FaceLandmark");
        int n10 = this.zza;
        zzf2 = zzf2.zza("type", n10);
        PointF pointF = this.zzb;
        return zzf2.zza("position", pointF).toString();
    }
}

