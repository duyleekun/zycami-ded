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

public class NvsHumanDetectionHandle$FaceData2D {
    private RectF bbox;
    private float pitch;
    private List points;
    private float roll;
    private List visibilities;
    private float yaw;

    public RectF getBbox() {
        return this.bbox;
    }

    public float getPitch() {
        return this.pitch;
    }

    public List getPoints() {
        return this.points;
    }

    public float getRoll() {
        return this.roll;
    }

    public List getVisibilities() {
        return this.visibilities;
    }

    public float getYaw() {
        return this.yaw;
    }

    public void setBbox(float f10, float f11, float f12, float f13) {
        RectF rectF;
        this.bbox = rectF = new RectF(f10, f11, f12, f13);
    }

    public void setPitch(float f10) {
        this.pitch = f10;
    }

    public void setPoints(ArrayList arrayList) {
        ArrayList arrayList2;
        this.points = arrayList2 = new ArrayList();
        this.points = arrayList;
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

