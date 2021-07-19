/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera.data;

public final class CameraSet$HitchcockGuide
extends Enum {
    public static final /* enum */ CameraSet$HitchcockGuide FINISH;
    public static final /* enum */ CameraSet$HitchcockGuide START;
    public static final /* enum */ CameraSet$HitchcockGuide THREE;
    public static final /* enum */ CameraSet$HitchcockGuide TWO;
    private static final /* synthetic */ CameraSet$HitchcockGuide[] a;
    private int id;
    private int stringRes;

    static {
        CameraSet$HitchcockGuide cameraSet$HitchcockGuide;
        CameraSet$HitchcockGuide cameraSet$HitchcockGuide2;
        CameraSet$HitchcockGuide cameraSet$HitchcockGuide3;
        CameraSet$HitchcockGuide cameraSet$HitchcockGuide4;
        FINISH = cameraSet$HitchcockGuide4 = new CameraSet$HitchcockGuide("FINISH", 0, 0, 2131951833);
        int n10 = 1;
        START = cameraSet$HitchcockGuide3 = new CameraSet$HitchcockGuide("START", n10, n10, 2131952329);
        int n11 = 2;
        TWO = cameraSet$HitchcockGuide2 = new CameraSet$HitchcockGuide("TWO", n11, n11, 2131952331);
        int n12 = 3;
        THREE = cameraSet$HitchcockGuide = new CameraSet$HitchcockGuide("THREE", n12, n12, 2131952330);
        CameraSet$HitchcockGuide[] cameraSet$HitchcockGuideArray = new CameraSet$HitchcockGuide[4];
        cameraSet$HitchcockGuideArray[0] = cameraSet$HitchcockGuide4;
        cameraSet$HitchcockGuideArray[n10] = cameraSet$HitchcockGuide3;
        cameraSet$HitchcockGuideArray[n11] = cameraSet$HitchcockGuide2;
        cameraSet$HitchcockGuideArray[n12] = cameraSet$HitchcockGuide;
        a = cameraSet$HitchcockGuideArray;
    }

    /*
     * WARNING - void declaration
     */
    private CameraSet$HitchcockGuide() {
        void var4_2;
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.id = var3_1;
        this.stringRes = var4_2;
    }

    public static CameraSet$HitchcockGuide valueOf(String string2) {
        return Enum.valueOf(CameraSet$HitchcockGuide.class, string2);
    }

    public static CameraSet$HitchcockGuide[] values() {
        return (CameraSet$HitchcockGuide[])a.clone();
    }

    public int getId() {
        return this.id;
    }

    public int getStringRes() {
        return this.stringRes;
    }

    public void setId(int n10) {
        this.id = n10;
    }

    public void setStringRes(int n10) {
        this.stringRes = n10;
    }
}

