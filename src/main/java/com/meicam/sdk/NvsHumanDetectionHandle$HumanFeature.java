/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsHumanDetectionHandle$FaceFeature;
import java.util.ArrayList;
import java.util.List;

public class NvsHumanDetectionHandle$HumanFeature {
    private List faceFeatureArray;

    public NvsHumanDetectionHandle$HumanFeature() {
        ArrayList arrayList;
        this.faceFeatureArray = arrayList = new ArrayList();
    }

    public void addFaceFeature(NvsHumanDetectionHandle$FaceFeature nvsHumanDetectionHandle$FaceFeature) {
        this.faceFeatureArray.add(nvsHumanDetectionHandle$FaceFeature);
    }

    public List getFaceFeatureArray() {
        return this.faceFeatureArray;
    }

    public int getFaceFeatureCount() {
        return this.faceFeatureArray.size();
    }

    public void removeFaceFeatureByIndex(int n10) {
        List list;
        int n11;
        if (n10 >= 0 && n10 < (n11 = (list = this.faceFeatureArray).size())) {
            list = this.faceFeatureArray;
            list.remove(n10);
        }
    }
}

