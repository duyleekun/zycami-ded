/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 */
package com.google.android.gms.vision.face;

import android.graphics.PointF;
import com.google.android.gms.vision.face.Contour;
import com.google.android.gms.vision.face.Landmark;
import java.util.Arrays;
import java.util.List;

public class Face {
    public static final float UNCOMPUTED_PROBABILITY = -1.0f;
    private float height;
    private int id;
    private float width;
    private PointF zzcg;
    private float zzch;
    private float zzci;
    private float zzcj;
    private List zzck;
    private final List zzcl;
    private float zzcm;
    private float zzcn;
    private float zzco;
    private final float zzcp;

    public Face(int n10, PointF pointF, float f10, float f11, float f12, float f13, float f14, Landmark[] landmarkArray, Contour[] contourArray, float f15, float f16, float f17, float f18) {
        float f19;
        List<Object> list;
        this.id = n10;
        this.zzcg = pointF;
        this.width = f10;
        this.height = f11;
        this.zzch = f12;
        this.zzci = f13;
        this.zzcj = f14;
        this.zzck = list = Arrays.asList(landmarkArray);
        this.zzcl = list = Arrays.asList(contourArray);
        this.zzcm = f19 = Face.zza(f15);
        this.zzcn = f19 = Face.zza(f16);
        this.zzco = f19 = Face.zza(f17);
        this.zzcp = f19 = Face.zza(f18);
    }

    private static float zza(float f10) {
        float f11;
        float f12 = 0.0f;
        float f13 = f10 - 0.0f;
        Object object = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        if (object >= 0 && (object = (f11 = f10 - (f12 = 1.0f)) == 0.0f ? 0 : (f11 < 0.0f ? -1 : 1)) <= 0) {
            return f10;
        }
        return -1.0f;
    }

    public List getContours() {
        return this.zzcl;
    }

    public float getEulerX() {
        return this.zzcj;
    }

    public float getEulerY() {
        return this.zzch;
    }

    public float getEulerZ() {
        return this.zzci;
    }

    public float getHeight() {
        return this.height;
    }

    public int getId() {
        return this.id;
    }

    public float getIsLeftEyeOpenProbability() {
        return this.zzcm;
    }

    public float getIsRightEyeOpenProbability() {
        return this.zzcn;
    }

    public float getIsSmilingProbability() {
        return this.zzco;
    }

    public List getLandmarks() {
        return this.zzck;
    }

    public PointF getPosition() {
        PointF pointF = this.zzcg;
        float f10 = pointF.x;
        float f11 = this.width;
        float f12 = 2.0f;
        float f13 = pointF.y;
        f11 = this.height / f12;
        PointF pointF2 = new PointF(f10 -= (f11 /= f12), f13 -= f11);
        return pointF2;
    }

    public float getWidth() {
        return this.width;
    }
}

