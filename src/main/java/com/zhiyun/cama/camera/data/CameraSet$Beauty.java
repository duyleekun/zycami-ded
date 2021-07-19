/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera.data;

public final class CameraSet$Beauty
extends Enum {
    public static final /* enum */ CameraSet$Beauty AUTO;
    public static final /* enum */ CameraSet$Beauty EXFOLIATING;
    public static final /* enum */ CameraSet$Beauty EYES_ENLARGED;
    public static final /* enum */ CameraSet$Beauty LIGHT;
    public static final /* enum */ CameraSet$Beauty OFF;
    public static final /* enum */ CameraSet$Beauty RUDDY;
    public static final /* enum */ CameraSet$Beauty SHIN_FACE;
    public static final /* enum */ CameraSet$Beauty WHITENING;
    private static final /* synthetic */ CameraSet$Beauty[] a;
    private int drawableRes;
    private int id;
    private int stringRes;

    static {
        CameraSet$Beauty cameraSet$Beauty;
        CameraSet$Beauty cameraSet$Beauty2;
        CameraSet$Beauty cameraSet$Beauty3;
        CameraSet$Beauty cameraSet$Beauty4;
        CameraSet$Beauty cameraSet$Beauty5;
        CameraSet$Beauty[] cameraSet$BeautyArray;
        CameraSet$Beauty[] cameraSet$BeautyArray2 = cameraSet$BeautyArray;
        cameraSet$BeautyArray = new CameraSet$Beauty("OFF", 0, 0, 2131951770, 2131231383);
        OFF = cameraSet$BeautyArray;
        CameraSet$Beauty[] cameraSet$BeautyArray3 = cameraSet$BeautyArray2;
        cameraSet$BeautyArray2 = new CameraSet$Beauty("AUTO", 1, 1, 2131951765, 2131231375);
        AUTO = cameraSet$BeautyArray2;
        CameraSet$Beauty cameraSet$Beauty6 = cameraSet$Beauty5;
        SHIN_FACE = cameraSet$Beauty5 = new CameraSet$Beauty("SHIN_FACE", 2, 2, 2131951774, 2131231381);
        cameraSet$BeautyArray3 = cameraSet$Beauty4;
        EXFOLIATING = cameraSet$Beauty4 = new CameraSet$Beauty("EXFOLIATING", 3, 3, 2131951766, 2131231376);
        cameraSet$Beauty6 = cameraSet$Beauty3;
        WHITENING = cameraSet$Beauty3 = new CameraSet$Beauty("WHITENING", 4, 4, 2131951775, 2131231382);
        cameraSet$BeautyArray3 = cameraSet$Beauty2;
        EYES_ENLARGED = cameraSet$Beauty2 = new CameraSet$Beauty("EYES_ENLARGED", 5, 5, 2131951767, 2131231377);
        cameraSet$Beauty6 = cameraSet$Beauty;
        LIGHT = cameraSet$Beauty = new CameraSet$Beauty("LIGHT", 6, 6, 2131951768, 2131231378);
        cameraSet$BeautyArray3 = cameraSet$Beauty6;
        RUDDY = cameraSet$Beauty6 = new CameraSet$Beauty("RUDDY", 7, 7, 2131951773, 2131231380);
        cameraSet$BeautyArray3 = new CameraSet$Beauty[]{cameraSet$BeautyArray, cameraSet$BeautyArray2, cameraSet$Beauty5, cameraSet$Beauty4, cameraSet$Beauty3, cameraSet$Beauty2, cameraSet$Beauty, cameraSet$Beauty6};
        a = cameraSet$BeautyArray3;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private CameraSet$Beauty(int n11) {
        void var5_3;
        void var4_2;
        void var2_-1;
        void var1_-1;
        this.id = n11;
        this.stringRes = var4_2;
        this.drawableRes = var5_3;
    }

    public static CameraSet$Beauty valueOf(String string2) {
        return Enum.valueOf(CameraSet$Beauty.class, string2);
    }

    public static CameraSet$Beauty[] values() {
        return (CameraSet$Beauty[])a.clone();
    }

    public int getDrawableRes() {
        return this.drawableRes;
    }

    public int getId() {
        return this.id;
    }

    public int getStringRes() {
        return this.stringRes;
    }

    public void setDrawableRes(int n10) {
        this.drawableRes = n10;
    }

    public void setId(int n10) {
        this.id = n10;
    }

    public void setStringRes(int n10) {
        this.stringRes = n10;
    }
}

