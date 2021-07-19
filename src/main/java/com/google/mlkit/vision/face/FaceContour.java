/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.vision.face;

import com.google.android.gms.internal.mlkit_vision_face.zzd;
import com.google.android.gms.internal.mlkit_vision_face.zzf;
import java.util.List;

public class FaceContour {
    public static final int FACE = 1;
    public static final int LEFT_CHEEK = 14;
    public static final int LEFT_EYE = 6;
    public static final int LEFT_EYEBROW_BOTTOM = 3;
    public static final int LEFT_EYEBROW_TOP = 2;
    public static final int LOWER_LIP_BOTTOM = 11;
    public static final int LOWER_LIP_TOP = 10;
    public static final int NOSE_BOTTOM = 13;
    public static final int NOSE_BRIDGE = 12;
    public static final int RIGHT_CHEEK = 15;
    public static final int RIGHT_EYE = 7;
    public static final int RIGHT_EYEBROW_BOTTOM = 5;
    public static final int RIGHT_EYEBROW_TOP = 4;
    public static final int UPPER_LIP_BOTTOM = 9;
    public static final int UPPER_LIP_TOP = 8;
    private final int zza;
    private final List zzb;

    public FaceContour(int n10, List list) {
        this.zza = n10;
        this.zzb = list;
    }

    public int getFaceContourType() {
        return this.zza;
    }

    public List getPoints() {
        return this.zzb;
    }

    public String toString() {
        zzf zzf2 = zzd.zza("FaceContour");
        int n10 = this.zza;
        zzf2 = zzf2.zza("type", n10);
        Object[] objectArray = this.zzb.toArray();
        return zzf2.zza("points", objectArray).toString();
    }
}

