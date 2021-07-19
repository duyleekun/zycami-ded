/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.effect.sdk;

import com.meicam.effect.sdk.NvsFaceFeaturePoint$FaceInfo;
import com.meicam.sdk.NvsArbitraryData;

public class NvsFaceFeaturePoint
extends NvsArbitraryData {
    public int faceCount;
    public NvsFaceFeaturePoint$FaceInfo[] faces;

    public static NvsFaceFeaturePoint createFaceFeaturePoint(int n10) {
        NvsFaceFeaturePoint nvsFaceFeaturePoint = new NvsFaceFeaturePoint();
        nvsFaceFeaturePoint.faceCount = n10;
        NvsFaceFeaturePoint$FaceInfo[] nvsFaceFeaturePoint$FaceInfoArray = new NvsFaceFeaturePoint$FaceInfo[n10];
        nvsFaceFeaturePoint.faces = nvsFaceFeaturePoint$FaceInfoArray;
        nvsFaceFeaturePoint$FaceInfoArray = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            NvsFaceFeaturePoint$FaceInfo nvsFaceFeaturePoint$FaceInfo;
            NvsFaceFeaturePoint$FaceInfo[] nvsFaceFeaturePoint$FaceInfoArray2 = nvsFaceFeaturePoint.faces;
            nvsFaceFeaturePoint$FaceInfoArray2[i10] = nvsFaceFeaturePoint$FaceInfo = new NvsFaceFeaturePoint$FaceInfo();
        }
        return nvsFaceFeaturePoint;
    }

    public NvsFaceFeaturePoint$FaceInfo getFaceFeatureFromIndex(int n10) {
        int n11;
        if (n10 >= 0 && n10 <= (n11 = this.faceCount)) {
            return this.faces[n10];
        }
        return null;
    }
}

