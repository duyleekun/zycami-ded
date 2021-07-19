/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera.data;

public final class CameraSet$Guide
extends Enum {
    public static final /* enum */ CameraSet$Guide FINISH;
    public static final /* enum */ CameraSet$Guide FIVE;
    public static final /* enum */ CameraSet$Guide FOUR;
    public static final /* enum */ CameraSet$Guide SEVEN;
    public static final /* enum */ CameraSet$Guide SIX;
    public static final /* enum */ CameraSet$Guide START;
    public static final /* enum */ CameraSet$Guide STORY_CUSTOM_ONE;
    public static final /* enum */ CameraSet$Guide STORY_CUSTOM_TWO;
    public static final /* enum */ CameraSet$Guide STORY_MORE;
    public static final /* enum */ CameraSet$Guide THREE;
    public static final /* enum */ CameraSet$Guide TWO;
    private static final /* synthetic */ CameraSet$Guide[] a;
    private int id;
    private int stringRes;

    static {
        CameraSet$Guide cameraSet$Guide;
        CameraSet$Guide cameraSet$Guide2;
        CameraSet$Guide cameraSet$Guide3;
        CameraSet$Guide cameraSet$Guide4;
        CameraSet$Guide cameraSet$Guide5;
        CameraSet$Guide cameraSet$Guide6;
        CameraSet$Guide cameraSet$Guide7;
        CameraSet$Guide cameraSet$Guide8;
        CameraSet$Guide cameraSet$Guide9;
        CameraSet$Guide cameraSet$Guide10;
        CameraSet$Guide cameraSet$Guide11;
        FINISH = cameraSet$Guide11 = new CameraSet$Guide("FINISH", 0, 0, 2131951833);
        int n10 = 1;
        START = cameraSet$Guide10 = new CameraSet$Guide("START", n10, n10, 2131951794);
        int n11 = 2;
        TWO = cameraSet$Guide9 = new CameraSet$Guide("TWO", n11, n11, 2131951798);
        int n12 = 3;
        THREE = cameraSet$Guide8 = new CameraSet$Guide("THREE", n12, n12, 2131951797);
        int n13 = 4;
        FOUR = cameraSet$Guide7 = new CameraSet$Guide("FOUR", n13, n13, 2131951793);
        int n14 = 5;
        FIVE = cameraSet$Guide6 = new CameraSet$Guide("FIVE", n14, n14, 2131951792);
        int n15 = 6;
        SIX = cameraSet$Guide5 = new CameraSet$Guide("SIX", n15, n15, 2131951796);
        n15 = 7;
        SEVEN = cameraSet$Guide4 = new CameraSet$Guide("SEVEN", n15, n15, 2131951795);
        n15 = 8;
        STORY_MORE = cameraSet$Guide3 = new CameraSet$Guide("STORY_MORE", n15, n15, 2131953117);
        n15 = 9;
        STORY_CUSTOM_ONE = cameraSet$Guide2 = new CameraSet$Guide("STORY_CUSTOM_ONE", n15, n15, 2131953118);
        n15 = 10;
        STORY_CUSTOM_TWO = cameraSet$Guide = new CameraSet$Guide("STORY_CUSTOM_TWO", n15, n15, 2131953119);
        CameraSet$Guide[] cameraSet$GuideArray = new CameraSet$Guide[11];
        cameraSet$GuideArray[0] = cameraSet$Guide11;
        cameraSet$GuideArray[n10] = cameraSet$Guide10;
        cameraSet$GuideArray[2] = cameraSet$Guide9;
        cameraSet$GuideArray[3] = cameraSet$Guide8;
        cameraSet$GuideArray[4] = cameraSet$Guide7;
        cameraSet$GuideArray[5] = cameraSet$Guide6;
        cameraSet$GuideArray[6] = cameraSet$Guide5;
        cameraSet$GuideArray[7] = cameraSet$Guide4;
        cameraSet$GuideArray[8] = cameraSet$Guide3;
        cameraSet$GuideArray[9] = cameraSet$Guide2;
        cameraSet$GuideArray[n15] = cameraSet$Guide;
        a = cameraSet$GuideArray;
    }

    /*
     * WARNING - void declaration
     */
    private CameraSet$Guide() {
        void var4_2;
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.id = var3_1;
        this.stringRes = var4_2;
    }

    public static CameraSet$Guide valueOf(String string2) {
        return Enum.valueOf(CameraSet$Guide.class, string2);
    }

    public static CameraSet$Guide[] values() {
        return (CameraSet$Guide[])a.clone();
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

