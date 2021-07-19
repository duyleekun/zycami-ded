/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.effect.sdk;

import com.meicam.sdk.NvsPosition2D;

public class NvsFaceFeaturePoint$FaceInfo {
    public int ID;
    public NvsPosition2D[] points_array;
    public float[] visibility_array;

    public NvsFaceFeaturePoint$FaceInfo() {
        int n10 = 106;
        NvsPosition2D[] nvsPosition2DArray = new NvsPosition2D[n10];
        this.points_array = nvsPosition2DArray;
        float[] fArray = new float[n10];
        this.visibility_array = fArray;
    }

    public int getID() {
        return this.ID;
    }

    public NvsPosition2D[] getPoints_array() {
        return this.points_array;
    }

    public float[] getVisibilityArray() {
        return this.visibility_array;
    }

    public void setID(int n10) {
        this.ID = n10;
    }

    public void setPoints_array(NvsPosition2D[] nvsPosition2DArray) {
        this.points_array = nvsPosition2DArray;
    }
}

