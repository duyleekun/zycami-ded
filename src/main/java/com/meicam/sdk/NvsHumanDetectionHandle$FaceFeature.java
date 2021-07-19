/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsHumanDetectionHandle$FaceData2D;
import com.meicam.sdk.NvsHumanDetectionHandle$FaceData3D;
import java.util.ArrayList;
import java.util.List;

public class NvsHumanDetectionHandle$FaceFeature {
    private List actions;
    private List avatarExpressions;
    private NvsHumanDetectionHandle$FaceData2D faceData2D;
    private NvsHumanDetectionHandle$FaceData3D faceData3D;
    private int faceId;
    private float score;

    public NvsHumanDetectionHandle$FaceData2D FaceData2D() {
        return this.faceData2D;
    }

    public NvsHumanDetectionHandle$FaceData3D FaceData3D() {
        return this.faceData3D;
    }

    public List getActions() {
        return this.actions;
    }

    public List getAvatarExpressions() {
        return this.avatarExpressions;
    }

    public int getFaceId() {
        return this.faceId;
    }

    public float getScore() {
        return this.score;
    }

    public void setActions(ArrayList arrayList) {
        ArrayList arrayList2;
        this.actions = arrayList2 = new ArrayList();
        this.actions = arrayList;
    }

    public void setAvatarExpressions(ArrayList arrayList) {
        ArrayList arrayList2;
        this.avatarExpressions = arrayList2 = new ArrayList();
        this.avatarExpressions = arrayList;
    }

    public void setFaceData2D(NvsHumanDetectionHandle$FaceData2D nvsHumanDetectionHandle$FaceData2D) {
        NvsHumanDetectionHandle$FaceData2D nvsHumanDetectionHandle$FaceData2D2;
        this.faceData2D = nvsHumanDetectionHandle$FaceData2D2 = new NvsHumanDetectionHandle$FaceData2D();
        this.faceData2D = nvsHumanDetectionHandle$FaceData2D;
    }

    public void setFaceData3D(NvsHumanDetectionHandle$FaceData3D nvsHumanDetectionHandle$FaceData3D) {
        NvsHumanDetectionHandle$FaceData3D nvsHumanDetectionHandle$FaceData3D2;
        this.faceData3D = nvsHumanDetectionHandle$FaceData3D2 = new NvsHumanDetectionHandle$FaceData3D();
        this.faceData3D = nvsHumanDetectionHandle$FaceData3D;
    }

    public void setFaceId(int n10) {
        this.faceId = n10;
    }

    public void setScore(float f10) {
        this.score = f10;
    }
}

