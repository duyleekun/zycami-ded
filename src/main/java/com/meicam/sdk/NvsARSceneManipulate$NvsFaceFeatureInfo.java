/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.RectF
 */
package com.meicam.sdk;

import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

public class NvsARSceneManipulate$NvsFaceFeatureInfo {
    public RectF boundingBox;
    public int faceId;
    public List landmarks;
    public float pitch;
    public float roll;
    public List visibilities;
    public float yaw;

    public void setBoundingBox(float f10, float f11, float f12, float f13) {
        RectF rectF;
        this.boundingBox = rectF = new RectF(f10, f11, f12, f13);
    }

    public void setFaceId(int n10) {
        this.faceId = n10;
    }

    public void setLandmarks(ArrayList arrayList) {
        ArrayList arrayList2;
        this.landmarks = arrayList2 = new ArrayList();
        this.landmarks = arrayList;
    }

    public void setPitch(float f10) {
        this.pitch = f10;
    }

    public void setRoll(float f10) {
        this.roll = f10;
    }

    public void setVisibilities(ArrayList arrayList) {
        ArrayList arrayList2;
        this.visibilities = arrayList2 = new ArrayList();
        this.visibilities = arrayList;
    }

    public void setYaw(float f10) {
        this.yaw = f10;
    }
}

