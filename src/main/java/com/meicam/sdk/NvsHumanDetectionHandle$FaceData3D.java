/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsPosition3D;
import java.util.ArrayList;
import java.util.List;

public class NvsHumanDetectionHandle$FaceData3D {
    private NvsPosition3D rot;
    private NvsPosition3D trans;
    private List vertices;

    public NvsPosition3D getRot() {
        return this.rot;
    }

    public NvsPosition3D getTrans() {
        return this.trans;
    }

    public List getVertices() {
        return this.vertices;
    }

    public void setRot(NvsPosition3D nvsPosition3D) {
        NvsPosition3D nvsPosition3D2;
        float f10 = nvsPosition3D.x;
        float f11 = nvsPosition3D.y;
        float f12 = nvsPosition3D.z;
        this.rot = nvsPosition3D2 = new NvsPosition3D(f10, f11, f12);
    }

    public void setTrans(NvsPosition3D nvsPosition3D) {
        NvsPosition3D nvsPosition3D2;
        float f10 = nvsPosition3D.x;
        float f11 = nvsPosition3D.y;
        float f12 = nvsPosition3D.z;
        this.trans = nvsPosition3D2 = new NvsPosition3D(f10, f11, f12);
    }

    public void setVertices(ArrayList arrayList) {
        ArrayList arrayList2;
        this.vertices = arrayList2 = new ArrayList();
        this.vertices = arrayList;
    }
}

